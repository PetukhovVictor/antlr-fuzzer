import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.0-rc-146"
}

group = "org.jetbrains.kotlin"
version = "0.1"

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.antlr:antlr4-runtime:4.7.1")
    compile("org.antlr:ST4:4.0.8")
    compile("org.antlr:antlr4:4.7.1")
    compile("com.github.mifmif:generex:1.0.2")

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}