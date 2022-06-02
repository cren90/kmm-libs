import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

buildscript {
    apply(from="versions.gradle.kts")

    val kotlinVersion: String by extra
    val gradleVersion: String by extra
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:$gradleVersion")
    }
}

allprojects {
    repositories {
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}