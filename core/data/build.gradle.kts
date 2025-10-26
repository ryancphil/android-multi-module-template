plugins {
    alias(libs.plugins.multimoduletemplate.android.library)
    alias(libs.plugins.multimoduletemplate.jvm.ktor)
}

android {
    namespace = "com.ryanphillips.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)
}