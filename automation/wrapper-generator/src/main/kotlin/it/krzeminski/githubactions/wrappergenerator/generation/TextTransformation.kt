package it.krzeminski.githubactions.wrappergenerator.generation

import java.util.Locale

fun String.toKotlinPackageName() =
    replace("-", "")
        .lowercase()

fun String.toPascalCase(): String {
    val hasOnlyUppercases = none { it in 'a'..'z' }
    val normalizedString = if (hasOnlyUppercases) lowercase() else this
    return normalizedString.replace("+", "-plus-")
        .split("-", "_", " ", ".")
        .joinToString("") {
            it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
}

fun String.toCamelCase(): String =
    toPascalCase().replaceFirstChar { it.lowercase() }
