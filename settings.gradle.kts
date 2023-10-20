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
        //pangle
        maven(url = "https://artifact.bytedance.com/repository/pangle")
    }
}

rootProject.name = "panglevttest"
include(":app")
 