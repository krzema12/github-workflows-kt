import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application

    // Code quality.
    id("org.jlleitschuh.gradle.ktlint")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.charleskorn.kaml:kaml:0.46.0")
    implementation("com.squareup:kotlinpoet:1.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    testImplementation(platform("io.kotest:kotest-bom:5.4.0"))
    testImplementation("io.kotest:kotest-assertions-core")
    testImplementation("io.kotest:kotest-runner-junit5")
    testImplementation(projects.library)
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("it.krzeminski.githubactions.wrappergenerator.GenerationEntryPointKt")
}

tasks.run.configure {
    finalizedBy(":library:ktlintFormat")
    workingDir(rootProject.layout.projectDirectory)
}

tasks.register<JavaExec>("suggestVersions") {
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("it.krzeminski.githubactions.wrappergenerator.versions.SuggestVersionsKt")
    dependsOn(tasks.compileKotlin)
}

ktlint {
    filter {
        exclude("**/wrappersfromunittests/**")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        allWarningsAsErrors = true
    }
}
