plugins {
    kotlin("jvm") version "1.9.0"
    antlr
}

group = "dev.tbashiyy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.13.1")
    testImplementation(kotlin("test"))
}

tasks.generateGrammarSource {
//    outputDirectory = File("./src/main/kotlin/dev/tbashiyy/antlr/parser")
    arguments = arguments + listOf("-visitor", "-long-messages")
}

tasks.named("compileKotlin") {
    dependsOn(":generateGrammarSource")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}