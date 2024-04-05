package io.github.typesafegithub.workflows.jitbindingserver

import io.github.typesafegithub.workflows.mavenbinding.buildJar
import io.github.typesafegithub.workflows.mavenbinding.buildModuleFile
import io.github.typesafegithub.workflows.mavenbinding.buildPomFile
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.head
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/binding/{owner}/{name}/{version}/{file}") {
                val owner = call.parameters["owner"]!!
                val name = call.parameters["name"]!!
                val version = call.parameters["version"]!!
                val file = call.parameters["file"]!!
                when (file) {
                    "$name-$version.jar" -> {
                        val jarByteArray = buildJar(owner = owner, name = name, version = version)
                        call.respondBytes(
                            bytes = jarByteArray,
                            contentType = ContentType.parse("application/java-archive"),
                        )
                    }
                    "$name-$version.pom" -> call.respondText(buildPomFile(owner = owner, name = name, version = version))
                    "$name-$version.module" -> call.respondText(buildModuleFile(owner = owner, name = name, version = version))
                    else -> call.respondText(text = "Not found", status = HttpStatusCode.NotFound)
                }
            }

            head("/binding/{owner}/{name}/{version}/{file}") {
                val name = call.parameters["name"]!!
                val version = call.parameters["version"]!!
                val file = call.parameters["file"]!!
                when (file) {
                    "$name-$version.jar" -> call.respondText("ok", status = HttpStatusCode.OK)
                    "$name-$version.pom" -> call.respondText("ok", status = HttpStatusCode.OK)
                    "$name-$version.module" -> call.respondText("ok", status = HttpStatusCode.OK)
                    else -> call.respondText(text = "Not found", status = HttpStatusCode.NotFound)
                }
            }

            get("/status") {
                call.respondText("OK")
            }
        }
    }.start(wait = true)
}
