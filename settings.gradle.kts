rootProject.name = "kotlinDemo"

pluginManagement {
    repositories {
        maven {
            setUrl("https://artifactory.tcsbank.ru/artifactory/maven-all")
        }
    }
}

buildscript {
    repositories {
        maven {
            setUrl("https://artifactory.tcsbank.ru/artifactory/maven-all")
        }
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            setUrl("https://artifactory.tcsbank.ru/artifactory/maven-all")
        }
    }
}
