/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

rootProject.name = "flex-module-sample"

include(":corehr:api")
include(":corehr:application-api")
include(":corehr:exception")
include(":corehr:infrastructure")
include(":corehr:model")
include(":corehr:repository-jdbc")
include(":corehr:schema")
include(":corehr:service")

pluginManagement {
    buildscript {
        repositories {
            gradlePluginPortal()
        }
    }

    repositories {
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
