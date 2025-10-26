plugins {
    alias(libs.plugins.multimoduletemplate.android.library.compose)
}

android {
    namespace = "com.ryanphillips.core.presentation.designsystem"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.material3)
}