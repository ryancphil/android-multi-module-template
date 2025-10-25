plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
/**
 * This (core:domain) is a pure kotlin/jvm module, and
 * therefore shouldn't depend on Android libraries.
 */
dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
