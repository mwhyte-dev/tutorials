import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
}

java.sourceCompatibility = JavaVersion.VERSION_11

group = "com.codenerve"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

var resilience4jVersion = "1.5.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("io.github.resilience4j:resilience4j-kotlin:${resilience4jVersion}")
    implementation("io.github.resilience4j:resilience4j-retry:${resilience4jVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

