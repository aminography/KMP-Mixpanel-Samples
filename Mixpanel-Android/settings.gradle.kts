pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/YouSee/youSee-KMP")
            credentials {
                val properties = java.util.Properties().apply {
//                    rootProject.file("../local.properties")
//                        .takeIf { it.exists() }
//                        ?.let { load(java.io.FileInputStream(it)) }
                }
                username = properties["gpr.usr"]?.toString() ?: System.getenv("GPR_USER")
                password = properties["gpr.key"]?.toString() ?: System.getenv("GPR_KEY")
            }
        }
    }
}

rootProject.name = "Mixpanel-Android"
include(":app")
 