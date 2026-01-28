rootProject.name = "kotlinDemo"

pluginManagement {
    repositories {
        maven {
            setUrl("https://artifactory.tcsbank.ru/artifactory/maven-all")
        }
        mavenLocal()
    }
}

buildscript {
    repositories {
        maven {
            setUrl("https://artifactory.tcsbank.ru/artifactory/maven-all")
        }
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            setUrl("https://artifactory.tcsbank.ru/artifactory/maven-all")
        }
        mavenLocal()
    }
}
