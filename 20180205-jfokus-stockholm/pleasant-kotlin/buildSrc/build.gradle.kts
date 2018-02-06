buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

apply {
    plugin("kotlin")
}

dependencies {
    compile("org.ysb33r.gradle:vfs-gradle-plugin:1.0")
    compile("commons-httpclient:commons-httpclient:3.1")
    compile(gradleScriptKotlinApi())
    compile(kotlinModule("stdlib"))
}

repositories {
    jcenter()
}
