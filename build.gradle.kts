plugins {
    java
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "com.librarymanager.Main"
        )
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0-M2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.0-M2")
}