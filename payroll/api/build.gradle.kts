/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

dependencies {
    implementation(project(":payroll:exception"))
    implementation(project(":payroll:service"))

    integrationTestImplementation("org.springframework.security:spring-security-test")
}
