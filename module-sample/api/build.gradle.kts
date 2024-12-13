/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

dependencies {
    implementation(project(":module-sample:exception"))
    implementation(project(":module-sample:service"))

    integrationTestImplementation("org.springframework.security:spring-security-test")
}
