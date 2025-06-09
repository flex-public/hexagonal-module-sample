/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

dependencies {
    implementation(project(":corehr:exception"))
    implementation(project(":corehr:service"))

    integrationTestImplementation("org.springframework.security:spring-security-test")
}
