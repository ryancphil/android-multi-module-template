plugins {
    alias(libs.plugins.multimoduletemplate.android.library)
}

android {
    namespace = "com.ryanphillips.core.database"
}

dependencies {
    implementation(projects.core.domain)
}