import kotlin.system.exitProcess

plugins {
    java
    alias(libs.plugins.publishdata)
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

if (!File("$rootDir/.git").exists()) {
    logger.lifecycle("""
    **************************************************************************************
    You need to fork and clone this repository! Don't download a .zip file.
    If you need assistance, consult the GitHub docs: https://docs.github.com/get-started/quickstart/fork-a-repo
    **************************************************************************************
    """.trimIndent()
    ).also { exitProcess(1) }
}

group = "net.onelitefeather"
version = "0.1.0"
description = "Provides block protection for your server."

dependencies {
    implementation(platform(libs.intellectual.sites.bom))
    compileOnly(libs.fawe.core)
    compileOnly(libs.fawe.bukkit)
    compileOnly(libs.papermc.api)
    implementation(libs.bstats)
    implementation(libs.hikaricp)
    implementation(libs.oshi.core)
}

java {
    withSourcesJar()
    withJavadocJar()

    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

publishData {
    addBuildData()
    useEldoNexusRepos(false)
    publishTask("shadowJar")
}

tasks {
    jar {
        archiveClassifier.set("original")
        manifest {
            attributes["paperweight-mappings-namespace"] = "mojang"
        }
    }
    shadowJar {
        dependencies {
            relocate("org.bstats", project.group.toString())
            relocate("com.zaxxer", project.group.toString())
        }
    }
}