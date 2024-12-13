/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

dependencies {
    implementation(project(":module-sample:infrastructure"))
    implementation("org.liquibase:liquibase-core")

    integrationTestImplementation("org.testcontainers:mysql")
    integrationTestImplementation(project(":module-sample:schema"))
    integrationTestRuntimeOnly("com.mysql:mysql-connector-j") {
        exclude(group = "com.google.protobuf", module = "protobuf-java")
    }
}
