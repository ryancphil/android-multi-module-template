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
    // and allow access to the apis we use in our convention plugins.
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

/**
 * This is where we register our convention plugins.
 */
gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "multimoduletemplate.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "multimoduletemplate.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "multimoduletemplate.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "multimoduletemplate.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeatureUi") {
            id = "multimoduletemplate.android.feature.ui"
            implementationClass = "AndroidFeatureUiConventionPlugin"
        }
    }
}