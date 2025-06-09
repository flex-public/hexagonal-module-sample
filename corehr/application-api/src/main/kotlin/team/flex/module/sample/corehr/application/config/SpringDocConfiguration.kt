/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.application.config

import org.springdoc.core.customizers.OpenApiCustomizer
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfiguration {
    @Bean
    fun coreHrGroupedOpenApi(openApiCustomizers: List<OpenApiCustomizer>): GroupedOpenApi =
        GroupedOpenApi.builder()
            .group("corehr")
            .pathsToMatch(
                "/api/v2/corehr/**",
            )
            .apply {
                openApiCustomizers.forEach {
                    addOpenApiCustomizer(it)
                }
            }
            .build()
}
