/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

rootProject.name = "flex-module-sample"

include(":module-sample:api")
include(":module-sample:application-api")
include(":module-sample:exception")
include(":module-sample:infrastructure")
include(":module-sample:model")
include(":module-sample:repository-jdbc")
include(":module-sample:schema")
include(":module-sample:service")

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
