rootProject.name = "github-workflows-kt-monorepo"

apply(from = "./buildSrc/repositories.settings.gradle.kts")

include(
    "github-workflows-kt",
    "action-binding-generator",
    "maven-binding-builder",
    "jit-binding-server",
    "shared-internal",
    ":automation:code-generator",
)

plugins {
    id("com.gradle.enterprise") version "3.16.2"
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage") // Central declaration of repositories is an incubating feature
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlwaysIf(System.getenv("GITHUB_ACTIONS") == "true")
        publishOnFailure()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
