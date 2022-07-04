import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.4.21"
    application
}

group = "com.nodil"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-websockets:2.0.2")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("io.ktor:ktor-client-cio:2.0.2")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.17.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.2")
    implementation("org.apache.logging.log4j:log4j-core:2.17.2")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("commons-codec:commons-codec:1.15")
    testImplementation(kotlin("test"))

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}