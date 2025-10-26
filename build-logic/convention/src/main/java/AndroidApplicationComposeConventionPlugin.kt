import com.android.build.api.dsl.ApplicationExtension
import com.ryanphillips.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * This Convention Plugin is for configuring Compose for Android App Modules.
 */
class AndroidApplicationComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            /**
             * Every Compose module is an Android App Module, but not vice-versa.
             * So we apply our Android Application Convention Plugin here via its ID,
             * and define the Compose Convention plugin separately to leverage modularity.
             */
            pluginManager.apply("multimoduletemplate.android.application")
            pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }

}