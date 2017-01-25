package kotlin.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloWorldPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("helloWorld").doLast { println("Hello devoxx"); }
    }
}