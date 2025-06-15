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
include(":payroll:api")
include(":payroll:application-api")
include(":payroll:exception")
include(":payroll:infrastructure")
include(":payroll:model")
include(":payroll:repository-jdbc")
include(":payroll:schema")
include(":payroll:service")

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
