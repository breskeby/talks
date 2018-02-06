import org.asciidoctor.gradle.AsciidoctorTask

plugins {
    java // for sourceSets access
    id("com.github.jruby-gradle.base") version "1.4.0"
    id("org.asciidoctor.convert") version "1.5.3"
    id("org.ajoberstar.git-publish") version "0.2.1"
}

apply {
    from("gradle/pdf.gradle")
}

dependencies {
    val gems by configurations
    gems("rubygems:slim:2.1.0")
    gems("rubygems:thread_safe:0.3.4")
}

asciidoctorj {
    version = "1.5.4"
}

gitPublish {
    repoUri = "git@github.com:bamboo/summit-2017-pleasant-authoring.git"
    branch = "gh-pages"
    contents {
        from(file("$buildDir/asciidoc/revealjs"))
    }
}

tasks {

    "gitPublishCopy" {
        dependsOn("asciidoctor")
    }

    val download by creating(DownloadRevealJsBackend::class)

    val themeDir = File(buildDir, "theme")
    val revealJsDir = File(themeDir, "reveal.js")
    val copyTheme by creating(Copy::class) {
        dependsOn(download)
        from(fileTree(download.revealJsDir))
        from(fileTree("src/docs/theme"))
        into(revealJsDir)
    }

    "asciidoctor"(AsciidoctorTask::class) {
        dependsOn(copyTheme)

        sources(delegateClosureOf<PatternSet> {
            include("index.adoc")
        })

        resources(delegateClosureOf<CopySpec> {
            from(sourceDir) {
                include("images/**")
            }
            from(themeDir) {
                include("reveal.js/**")
            }
        })

        backends("revealjs")

        val main by project.java.sourceSets
        attributes(
            mapOf(
                "sourcedir" to main.java.srcDirs.first(),
                "endpoint-url" to "http://example.org",
                "source-highlighter" to "highlightjs",
                "imagesdir" to "./images",
                "toc" to "left",
                "icons" to "font",
                "setanchors" to "true",
                "idprefix" to "",
                "idseparator" to "-",
                "basedir" to projectDir,
                "docinfo1" to "true",
                "width" to 1280,
                "height" to 720,
                "project-version" to "1.0",
                "revealjs_transition" to "linear",
                "revealjs_history" to "true",
                "revealjs_slideNumber" to "true",
                "revealjs_theme" to "summit",
                "examples" to file("$projectDir/examples")))

        val slimTemplateDir = File(download.asciidoctorBackendDir, "templates/slim").absolutePath
        options(mapOf("template_dirs" to listOf(slimTemplateDir)))
    }
}
