import org.gradle.api.plugins.ApplicationPlugin
import org.gradle.script.lang.kotlin.apply
import org.gradle.script.lang.kotlin.dependencies
import org.gradle.script.lang.kotlin.repositories
import org.gradle.script.lang.kotlin.testCompile

apply<ApplicationPlugin>()

repositories {
    jcenter()
}

dependencies {
    testCompile("junit:junit:4.12")
}
