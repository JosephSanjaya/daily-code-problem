dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
        mavenCentral()
    }
    versionCatalogs {
        create("core") {
            from(files("gradle/core.versions.toml"))
        }
    }
}

rootProject.name = "daily-code-problem"
