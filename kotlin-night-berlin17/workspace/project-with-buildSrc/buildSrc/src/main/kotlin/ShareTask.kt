
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.task

open class HelloTask : DefaultTask() {

    init {
        group = "My"
        description = "Prints a description of ${project.name}."
    }

    @TaskAction
    fun run() {
        println("I'm ${project.name}")
    }
}

/**
 * Declares a [HelloTask] named `hello`.
 */
fun Project.withHelloTask() =
    task<HelloTask>("hello")

