import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    kotlin("jvm") version embeddedKotlinVersion
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.9.22"))

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.22")

    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.5")
    implementation("org.jmailen.gradle:kotlinter-gradle:4.2.0")

    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.8.0"))
    implementation(("org.jetbrains.kotlinx:kotlinx-coroutines-core"))
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-opt-in=kotlin.time.ExperimentalTime",
        )
    }
}
