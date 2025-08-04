buildscript {
    dependencies {
        classpath("ru.tinkoff.kora:openapi-generator:${property("koraVersion")}")
    }
}

plugins {
    kotlin("jvm") version "1.9.25"
    idea
    application
    jacoco
    id("com.google.devtools.ksp") version "1.9.25-1.0.20"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

application {
    applicationName = "application"
    applicationDefaultJvmArgs = listOf("-Dfile.encoding=UTF-8")
}


kotlin {
    jvmToolchain { languageVersion.set(JavaLanguageVersion.of(21)) }

    sourceSets.test { kotlin.srcDir("build/generated/ksp/test/kotlin") }
}

val koraBom: Configuration by configurations.creating
configurations {
    ksp.get().extendsFrom(koraBom)
    compileOnly.get().extendsFrom(koraBom)
    api.get().extendsFrom(koraBom)
    implementation.get().extendsFrom(koraBom)
}

dependencies {
    koraBom(platform("ru.tinkoff.kora:kora-parent:${property("koraVersion")}"))
    ksp("ru.tinkoff.kora:symbol-processors")

    //kora
    implementation("ru.tinkoff.kora:http-server-undertow")
    implementation("ru.tinkoff.kora:kafka")
    implementation("ru.tinkoff.kora:database-jdbc")
    implementation("ru.tinkoff.kora:micrometer-module")
    implementation("ru.tinkoff.kora:json-module")
    implementation("ru.tinkoff.kora:validation-module")
    implementation("ru.tinkoff.kora:validation-common")
    implementation("ru.tinkoff.kora:cache-caffeine")
    implementation("ru.tinkoff.kora:resilient-kora")
    implementation("ru.tinkoff.kora:config-hocon")
    implementation("ru.tinkoff.kora:openapi-management")
    implementation("ru.tinkoff.kora:logging-logback")
    implementation("ru.tinkoff.kora:opentelemetry-tracing-exporter-grpc")
    implementation("ru.tinkoff.kora:grpc-client")
    implementation("ru.tinkoff.kora:http-client-ok")
    implementation("ru.tinkoff.kora:scheduling-jdk")
    implementation("ru.tinkoff.kora:openapi-management")

    // essentials
    implementation(platform("ru.tinkoff.essentials:essentials-bom:${property("essentialsVersion")}"))
    implementation("ru.tinkoff.essentials:kora-jdbc-util")
    implementation("ru.tinkoff.essentials:kora-kafka-util")
    implementation("ru.tinkoff.essentials:protobuf-util")
    implementation("ru.tinkoff.essentials:kora-web-filter")
    implementation("ru.tinkoff.essentials:sentry-kora-logback")
    implementation("ru.tinkoff.essentials:error-core-kotlin")
    implementation("ru.tinkoff.essentials:error-kora")
    implementation("ru.tinkoff.essentials:api-v3-kora-web-error-handler")
    implementation("ru.tinkoff.essentials:cache-browser-kora")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-test-junit5")
    implementation("junit:junit:4.13.2")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.3")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.17.3")

    // Postgres
    implementation("org.postgresql:postgresql:42.7.3")
}
