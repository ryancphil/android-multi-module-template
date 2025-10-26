/**
 * This build-logic "included build" (see root `settings.gradle.kts`) is used
 * to simplify gradle configuration and management for multi-module projects.
 */
plugins {
    `kotlin-dsl`
}
group = "com.ryanphillips.multimoduletemplate.buildlogic"

dependencies {
    // These are only needed at compile time for gradle building
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "multimoduletemplate.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}