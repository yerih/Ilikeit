buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
//        classpath("com.apollographql.apollo:apollo-gradle-plugin:3.7.3")
    }
}
//apply(plugin = "com.apollographql.apollo")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}