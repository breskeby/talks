plugins {
    application
}

application {
    mainClassName = "org.acme.Main"
}

group = "org.acme"

tasks {
    "printGroup" {
        doLast {
            println("This is my group: ${project.group}")
        }
    }
}