package io.github.typesafegithub.workflows.jitbindingserver

import io.github.reactivecircus.cache4k.Cache
import io.github.typesafegithub.workflows.actionbindinggenerator.domain.ActionCoords
import io.github.typesafegithub.workflows.mavenbinding.Artifact
import io.github.typesafegithub.workflows.mavenbinding.JarArtifact
import io.github.typesafegithub.workflows.mavenbinding.TextArtifact
import io.github.typesafegithub.workflows.mavenbinding.buildPackageArtifacts
import io.github.typesafegithub.workflows.mavenbinding.buildVersionArtifacts
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.head
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import kotlin.time.Duration.Companion.hours

fun main() {
    val bindingsCache =
        Cache.Builder<ActionCoords, Map<String, Artifact>>()
            .expireAfterAccess(1.hours)
            .build()

    embeddedServer(Netty, port = 8080) {
        routing {
            route("/binding/{owner}/{name}/{version}/{file}") {
                get {
                    val owner = call.parameters["owner"]!!
                    val name = call.parameters["name"]!!
                    val version = call.parameters["version"]!!
                    val actionCoords =
                        ActionCoords(
                            owner = owner,
                            name = name,
                            version = version,
                        )
                    val bindingArtifacts =
                        bindingsCache.get(actionCoords) {
                            actionCoords.buildVersionArtifacts()
                        }
                    val file = call.parameters["file"]!!
                    if (file in bindingArtifacts) {
                        when (val artifact = bindingArtifacts[file]) {
                            is TextArtifact -> call.respondText(artifact.data)
                            is JarArtifact ->
                                call.respondBytes(
                                    bytes = artifact.data,
                                    contentType = ContentType.parse("application/java-archive"),
                                )
                            else -> call.respondText(text = "Not found", status = HttpStatusCode.NotFound)
                        }
                    } else {
                        call.respondText(text = "Not found", status = HttpStatusCode.NotFound)
                    }
                }

                head {
                    val owner = call.parameters["owner"]!!
                    val name = call.parameters["name"]!!
                    val version = call.parameters["version"]!!
                    val file = call.parameters["file"]!!
                    val actionCoords =
                        ActionCoords(
                            owner = owner,
                            name = name,
                            version = version,
                        )
                    val bindingArtifacts =
                        bindingsCache.get(actionCoords) {
                            actionCoords.buildVersionArtifacts()
                        }
                    if (file in bindingArtifacts) {
                        call.respondText("Exists", status = HttpStatusCode.OK)
                    } else {
                        call.respondText(text = "Not found", status = HttpStatusCode.NotFound)
                    }
                }
            }

            route("/binding/{owner}/{name}/{file}") {
                get {
                    val owner = call.parameters["owner"]!!
                    val name = call.parameters["name"]!!
                    val file = call.parameters["file"]!!
                    val actionCoords =
                        ActionCoords(
                            owner = owner,
                            name = name,
                            version = "irrelevant",
                        )
                    val bindingArtifacts = actionCoords.buildPackageArtifacts(githubToken = System.getenv("GITHUB_TOKEN"))
                    if (file in bindingArtifacts) {
                        when (val artifact = bindingArtifacts[file]) {
                            is String -> call.respondText(artifact)
                            else -> call.respondText(text = "Not found", status = HttpStatusCode.NotFound)
                        }
                    } else {
                        call.respondText(text = "Not found", status = HttpStatusCode.NotFound)
                    }
                }
            }

            get("/status") {
                call.respondText("OK")
            }
        }
    }.start(wait = true)
}
