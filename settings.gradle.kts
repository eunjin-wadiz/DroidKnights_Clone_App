pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DroidKnights2023_Clone_App"
include(":app")
include(":feature:main")
include(":core:designsystem")
include(":feature:home")
include(":core:model")
include(":core:data")
include(":core:domain")
