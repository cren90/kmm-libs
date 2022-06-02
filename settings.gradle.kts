enableFeaturePreview("VERSION_CATALOGS")

object DependencyVersions {
    const val COROUTINES = "1.6.2"
}

pluginManagement {
    apply(from="versions.gradle.kts")

    val kotlinVersion: String by extra
    val gradleVersion: String by extra

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.google.com")
        maven(url = "https://jitpack.io")
    }

    resolutionStrategy.eachPlugin {
        if(requested.id.id.startsWith("org.jetbrains.kotlin")) {
            useVersion(kotlinVersion)
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://maven.google.com")
        maven(url = "https://jitpack.io")
    }

    versionCatalogs {
        create("libs") {
            library("serializationJson", "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
            library("coroutineCore", "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyVersions.COROUTINES}")
            library("datetime", "org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")

        }
    }
}

rootProject.name = "kmm-libs"
include(":lib-common")
include(":kmm-flow-event-bus")
