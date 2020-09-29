version = "0.0.1"

plugins {
    java
    kotlin("jvm") version "1.3.72" apply false
    kotlin("plugin.spring") version "1.3.72" apply false
    id("org.springframework.boot") version "2.3.2.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE" apply false
    id("com.google.cloud.tools.jib") version "2.5.0" apply false
}

subprojects {
    var buildNumber: String? = "DEV"

    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "application")
    apply(plugin = "maven-publish")
    apply(plugin = "com.google.cloud.tools.jib")

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")


        testImplementation("org.mockito:mockito-core:3.5.13")
        testImplementation("org.hamcrest:hamcrest-core:2.2")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}