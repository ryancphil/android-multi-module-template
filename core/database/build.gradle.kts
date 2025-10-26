plugins {
    alias(libs.plugins.multimoduletemplate.android.library)
    alias(libs.plugins.multimoduletemplate.android.room)
}

android {
    namespace = "com.ryanphillips.core.database"
}

dependencies {
    implementation(projects.core.domain)
}