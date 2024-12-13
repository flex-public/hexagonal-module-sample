/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

dependencies {
    implementation(project(":module-sample:schema"))
    implementation(project(":module-sample:api"))
    implementation(project(":module-sample:repository-jdbc"))

    implementation("org.testcontainers:mysql")
    runtimeOnly("com.mysql:mysql-connector-j") {
        exclude(group = "com.google.protobuf", module = "protobuf-java")
    }
}
