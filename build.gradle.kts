group = "com.eureka"
version = "1.0-SNAPSHOT"
description = "com.eureka optics"
java.sourceCompatibility = JavaVersion.VERSION_1_8

plugins {
    java
    idea
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
    kotlin("kapt") version "1.6.10"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(platform("io.arrow-kt:arrow-stack:1.0.0"))
    implementation("io.arrow-kt:arrow-core")
    implementation("io.arrow-kt:arrow-optics")
    kapt("io.arrow-kt:arrow-meta:1.0.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.3.60")
    testImplementation("junit:junit:4.12")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed")
    }

    reports {
        html.required.set(true)
    }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
