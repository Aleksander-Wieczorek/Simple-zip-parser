plugins {
    kotlin("jvm") version "1.9.10"
    application
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.ajalt.clikt:clikt:4.3.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0")

}

application {
    mainClass.set("com.example.plugininspector.MainKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.example.plugininspector.MainKt"
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

kotlin {
    jvmToolchain(17)
}
