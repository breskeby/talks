
import org.gradle.api.plugins.ApplicationPlugin
import org.gradle.api.plugins.ApplicationPluginConvention
import org.gradle.api.tasks.Copy
import org.gradle.script.lang.kotlin.*

apply<ApplicationPlugin>()

configure<ApplicationPluginConvention>(){
    mainClassName = "samples.HelloWorld"
}

task<Copy>("someCopy"){
    from()
}

repositories {
    jcenter()
}

dependencies {
    testCompile("junit:junit:4.12")
}
