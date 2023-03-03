import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    application
    alias(core.plugins.spotless)
}

group = "id.joseph.dailycodeproblem"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

spotless {
    kotlin {
        target(fileTree(rootDir) {
            include("**/*.kt")
            exclude(
                ".idea/**",
                "**/build/**",
                "build/**",
                ".gradle/**",
                "**/**/androidTest",
                "**/**/test",
                "**/androidTest",
                "**/test"
            )
        })
        diktat(core.versions.diktat.get()).configFile("diktat/rules.yml")
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
    }
    kotlinGradle {
        target("*.gradle.kts")
        diktat(core.versions.diktat.get()).configFile("diktat/rules.yml")
    }
}
