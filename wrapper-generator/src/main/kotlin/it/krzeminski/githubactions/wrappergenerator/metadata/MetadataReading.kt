package it.krzeminski.githubactions.wrappergenerator.metadata

import com.charleskorn.kaml.Yaml
import it.krzeminski.githubactions.wrappergenerator.domain.ActionCoords
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import java.io.File
import java.io.IOException
import java.net.URI
import java.time.LocalDate

/**
 * [Metadata syntax for GitHub Actions](https://docs.github.com/en/actions/creating-actions/metadata-syntax-for-github-actions).
 */

@Serializable
data class Metadata(
    val name: String,
    val description: String,
    val inputs: Map<String, Input> = emptyMap(),
    val outputs: Map<String, Output> = emptyMap(),
)

@Serializable
data class Input(
    val description: String = "",
    val default: String? = null,
    val required: Boolean? = null,
    val deprecationMessage: String? = null,
)

@Serializable
data class Output(
    val description: String,
)

val ActionCoords.actionYmlUrl: String get() = "https://raw.githubusercontent.com/$owner/$name/$version/action.yml"

val ActionCoords.actionYamlUrl: String get() = "https://raw.githubusercontent.com/$owner/$name/$version/action.yaml"

val ActionCoords.actionYmlNoVUrl: String get() = "https://raw.githubusercontent.com/$owner/$name/${version.removePrefix("v")}/action.yml"

val ActionCoords.actionYamlNoVUrl: String get() = "https://raw.githubusercontent.com/$owner/$name/${version.removePrefix("v")}/action.yml"

val ActionCoords.releasesUrl: String get() = "$gitHubUrl/releases"

val ActionCoords.gitHubUrl: String get() = "https://github.com/$owner/$name"

val ActionCoords.prettyPrint: String get() = """ActionCoords("$owner", "$name", "$version")"""

val ActionCoords.yamlName: String get() = "$owner/$name@$version"

fun ActionCoords.fetchMetadata(fetchUri: (URI) -> String = ::fetchUri): Metadata {
    val cacheFile = actionYamlDir.resolve("$owner-$name-$version.yml")
    if (cacheFile.canRead()) {
        println("  ... from cache: $cacheFile")
        return myYaml.decodeFromString(cacheFile.readText())
    }

    val list = listOf(actionYmlUrl, actionYamlUrl, actionYmlNoVUrl, actionYamlNoVUrl)
    val metadataYaml = list.firstNotNullOfOrNull { url ->
        try {
            println("  ... from $url")
            fetchUri(URI(url))
        } catch (e: IOException) {
            null
        }
    } ?: error("$prettyPrint\n†Can't fetch any of those URLs:\n- ${list.joinToString(separator = "\n- ")}\nCheck release page $releasesUrl")

    cacheFile.writeText(metadataYaml)
    return myYaml.decodeFromString(metadataYaml)
}

fun fetchUri(uri: URI) = uri.toURL().readText()

val myYaml = Yaml(
    configuration = Yaml.default.configuration.copy(
        strictMode = false,
    )
)

val actionYamlDir = File("build/action-yaml")

fun deleteActionYamlCacheIfObsolete() {
    val today = LocalDate.now().toString()
    val dateTxt = actionYamlDir.resolve("date.txt")
    val cacheUpToDate = dateTxt.canRead() && dateTxt.readText() == today

    if (!cacheUpToDate) {
        actionYamlDir.deleteRecursively()
        actionYamlDir.mkdir()
        dateTxt.writeText(today)
    }
}
