/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

import com.linecorp.support.project.multi.recipe.configureByTypeHaving
import com.linecorp.support.project.multi.recipe.configureByTypePrefix
import io.gitlab.arturbosch.detekt.DetektPlugin
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    `java-library`
    `jvm-test-suite`
    alias(libs.plugins.build.recipe)
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.detekt) apply false

    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
}

allprojects {
    findProperty("group")?.let {
        group = it
    }
}

configureByTypePrefix("kotlin") {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply<KtlintPlugin>()
    apply<DetektPlugin>()

    configure<KotlinJvmProjectExtension> {
        compilerOptions {
            freeCompilerArgs =
                listOf(
                    "-Xjsr305=strict",
                    "-Xjvm-default=all",
                    "-opt-in=kotlin.RequiresOptIn",
                    "-Xemit-jvm-type-annotations",
                )
        }
    }

    testing {
        suites {
            val test by getting(JvmTestSuite::class)
            val integrationTest by registering(JvmTestSuite::class)

            withType<JvmTestSuite> {
                useJUnitJupiter()

                targets {
                    all {
                        dependencies {
                            implementation(project())
                        }
                        testTask.configure {
                            shouldRunAfter(test)
                            testLogging {
                                events = mutableSetOf(TestLogEvent.FAILED)
                                exceptionFormat = TestExceptionFormat.FULL
                            }
                        }
                    }
                }
            }
        }
    }

    val integrationTestImplementation by configurations.getting {
        extendsFrom(configurations.testImplementation.get())
    }

    tasks {
        val check by getting {
            dependsOn("integrationTest")
        }
    }

    dependencies {
        implementation(enforcedPlatform(rootProject.libs.kotlin.bom))
        implementation(enforcedPlatform(rootProject.libs.kotlinx.coroutine.bom))

        implementation(kotlin("reflect"))
        implementation(kotlin("stdlib"))

        testImplementation(enforcedPlatform(SpringBootPlugin.BOM_COORDINATES))
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    }
}

configureByTypeHaving("dependencies") {
    dependencies {
        implementation(enforcedPlatform(SpringBootPlugin.BOM_COORDINATES))
    }
}

configureByTypeHaving("boot") {
    dependencies {
        implementation(enforcedPlatform(SpringBootPlugin.BOM_COORDINATES))

        implementation("org.springframework.boot:spring-boot-starter")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    }
}

configureByTypeHaving("kotlin", "boot") {
    apply(plugin = "kotlin-spring")
}

configureByTypeHaving("boot", "mvc") {
    dependencies {
        implementation("org.springframework.security:spring-security-core")
        implementation("org.springframework.boot:spring-boot-starter-web")

        implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
    }
}

configureByTypeHaving("boot", "jdbc", "repository") {
    dependencies {
        api("org.springframework.boot:spring-boot-starter-data-jdbc")
    }
}

configureByTypeHaving("boot", "application") {
    apply(plugin = "org.springframework.boot")

    dependencies {
        implementation("io.micrometer:micrometer-tracing-bridge-otel")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
    }
}

configureByTypeHaving("boot", "mvc", "application") {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
    }
}
