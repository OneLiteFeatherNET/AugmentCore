rootProject.name = "AgumentCore"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://eldonexus.de/repository/maven-public/")
    }
}


dependencyResolutionManagement {
    repositories {
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.codemc.org/repository/maven-public/")
    }
    versionCatalogs {
        create("libs") {
            version("intellectual-sites-bom", "1.52")
            version("publishdata", "1.4.0")

            library("intellectual.sites.bom", "com.intellectualsites.bom", "bom-newest").versionRef("intellectual-sites-bom")
            library("fawe.core", "com.fastasyncworldedit", "FastAsyncWorldEdit-Core").withoutVersion()
            library("fawe.bukkit", "com.fastasyncworldedit", "FastAsyncWorldEdit-Bukkit").withoutVersion()

            library("papermc.api", "io.papermc.paper", "paper-api").version("1.21-R0.1-SNAPSHOT")

            library("bstats", "org.bstats", "bstats-bukkit-lite").version("1.8")

            library("hikaricp", "com.zaxxer", "HikariCP").version("5.1.0")

            library("oshi-core", "com.github.oshi", "oshi-core").version("6.6.6")

            plugin("publishdata", "de.chojo.publishdata").versionRef("publishdata")
        }
    }
}