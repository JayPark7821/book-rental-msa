import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.5" apply false
    id("io.spring.dependency-management") version "1.1.3" apply false

    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22" apply false
    kotlin("plugin.jpa") version "1.8.22" apply false
}

group = "kr.jay"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

allprojects {
    group = "kr.jay"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.springframework.kafka:spring-kafka")
        // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-rest
        implementation("org.springframework.boot:spring-boot-starter-data-rest:3.1.5")
        // https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter
        implementation("io.springfox:springfox-boot-starter:3.0.0")
        // https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
        implementation("io.springfox:springfox-swagger-ui:3.0.0")

        runtimeOnly("com.h2database:h2")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.kafka:spring-kafka-test")
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs += "-Xjsr305=strict"
                jvmTarget = "17"
            }
        }
        withType<Test> {
            useJUnitPlatform()
        }
        named<Jar>("jar") {
            enabled = false
        }
    }
}
