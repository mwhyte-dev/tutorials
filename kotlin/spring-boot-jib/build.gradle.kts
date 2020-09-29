import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

var buildNumber: String

plugins {
    java
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    id("com.google.cloud.tools.jib")
}

group = "com.codenerve"
buildNumber = if (System.getenv("BUILD_NUMBER") != null )  System.getenv("BUILD_NUMBER") else "DEV"
version = "0.0.1-SNAPSHOT"


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

jib {
    to {
        image = "codenerve/spring-cloud-kotlin-gradle-jib"
    }
    container {
        workingDirectory = "/webservice"
        ports = listOf("8080")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
