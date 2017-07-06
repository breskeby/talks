
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke

open class MyPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            tasks {
                "goodbye" {
                    group = "My"
                    description = "Goodbye"
                    doLast {
                        println("If the plain leaves the ground and you're not with him, you'll regret it.")
                    }
                }
            }
        }
    }
}