/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

dependencies {
    implementation(project(":payroll:schema"))
    implementation(project(":payroll:api"))
    implementation(project(":payroll:repository-jdbc"))

    implementation("org.testcontainers:mysql")
    runtimeOnly("com.mysql:mysql-connector-j") {
        exclude(group = "com.google.protobuf", module = "protobuf-java")
    }
}
