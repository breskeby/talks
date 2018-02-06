plugins {
    application
}

application {
    mainClassName = "samples.HelloWorld"
}

repositories {
    jcenter()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    testCompile("junit:junit:4.12")
}

group = "org.acme"

tasks {
    "printGroup" {
        doLast {
            println("This is my group $group")
        }
    }
}