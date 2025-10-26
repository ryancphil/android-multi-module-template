# android-multi-module-template
A template project for multi-module Android projects based on Philipp Lackner's materials.

# Pros & Cons
|Category|Pros|Cons|
|---|---|---|
|🧠 Architecture|Enforces clean boundaries|Adds boilerplate, DI complexity|
|⚡ Performance|Faster incremental builds|Slower clean builds/config time|
|👥 Collaboration|Easier parallel work|Harder to refactor or navigate|
|🧪 Testing|Better isolation|More integration overhead|
|🧰 Maintenance|Reusable shared modules	|Versioning/dependency juggling|

# Things of Note
### `build-logic` Module
As the name implies, this module contains the _logic_ that determines how gradle _builds_ the project. This module differs in a critical way, specifically that it is provided to the top-level `settings.gradle.kts` as an **included build**.

`build.gradle.kts`|`settings.gradle.kts`|`Gradle Convention Plugins`|
|---|---|---|
|Enables `kotlin-dsl` plugin, compile-time gradle plugins, and registers Gradle Convention Plugins|Enables references to version catalog & includes convention submodule.|Implementations of `Plugin<Project>` interfaces. Saved in the `java` directory next to `com.ryanphillips.convention`|

### `implementation()` vs. `api()`
- Use `implementation` for internal dependencies: that are not part of the module's public contract and do not need to be exposed to consumers.
- Use `api` for dependencies that are part of the module's public API: and must be accessible to consuming modules at compile time.
  Prioritizing `implementation` whenever possible is generally recommended to improve build performance and enforce better module encapsulation. `api` should be used judiciously for dependencies that are truly part of the public interface.

### Top-level `build.gradle.kts`
If Convention plugins apply a gradle plugin, it needs to be added to the top-level `build.gradle.kts` file otherwise gradle will not be able to find it at compile time. This class has comments to show which Convention plugin requires which top-level plugin declaration.

### Top-level `settings.gradle.kts`
- As previously mentioned, this is where `build-logic` is provided as an included build instead of a regular project dependency.
- Enables `TYPESAFE_PROJECT_ACCESSORS` in other `build.gradle.kts` gradle files
- Includes all other project modules. They are added by default when created.

# Creating New Modules
When you create a new module you will have to sanitize its `build.gradle.kts` and leverage the convention plugins (or potentially write new ones) to provide the necessary build information for gradle. 


