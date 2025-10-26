plugins {
    alias(libs.plugins.multimoduletemplate.android.library)
}

android {
    namespace = "com.ryanphillips.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)
}