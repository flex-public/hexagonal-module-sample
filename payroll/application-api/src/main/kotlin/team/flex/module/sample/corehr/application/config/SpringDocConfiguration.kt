/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll.application.config

import org.springdoc.core.customizers.OpenApiCustomizer
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfiguration {
    @Bean
    fun payrollGroupedOpenApi(openApiCustomizers: List<OpenApiCustomizer>): GroupedOpenApi =
        GroupedOpenApi.builder()
            .group("payroll")
            .pathsToMatch(
                "/api/v2/payroll/**",
            )
            .apply {
                openApiCustomizers.forEach {
                    addOpenApiCustomizer(it)
                }
            }
            .build()
}
