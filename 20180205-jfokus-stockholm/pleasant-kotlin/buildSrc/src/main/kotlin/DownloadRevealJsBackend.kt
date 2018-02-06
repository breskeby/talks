import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

import org.ysb33r.groovy.dsl.vfs.VFS

import java.io.File

open class DownloadRevealJsBackend : DefaultTask() {

    val asciidoctorBackendVersion = "1.0.4"

    val revealJsVersion = "3.5.0"

    init {
        group = "download"
        description = "Downloads the reveal.js library and asciidoctor backend."
        inputs.property("asciidoctorBackendVersion", asciidoctorBackendVersion)
        inputs.property("revealJsVersion", revealJsVersion)
    }

    val downloadDir: File by lazy {
        File(project.buildDir, "download")
    }

    @get:OutputDirectory
    val asciidoctorBackendDir: File by lazy {
        File(downloadDir, asciidoctorBackendDirName)
    }

    @get:OutputDirectory
    val revealJsDir: File by lazy {
        File(downloadDir, revealJsDirName)
    }

    private
    val asciidoctorBackendDirName get() = "asciidoctor-reveal.js-$asciidoctorBackendVersion"

    private
    val revealJsDirName = "reveal.js-$revealJsVersion"

    @TaskAction
    fun download() {

        val options = mapOf("recursive" to true, "overwrite" to true)
        with (VFS()) {
            cp(options,
                "zip:https://github.com/asciidoctor/asciidoctor-reveal.js/archive/v$asciidoctorBackendVersion.zip!$asciidoctorBackendDirName",
                downloadDir)
            cp(options,
                "zip:https://github.com/hakimel/reveal.js/archive/$revealJsVersion.zip!$revealJsDirName",
                downloadDir)
        }
    }
}
