/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.repository

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@AutoConfiguration
@EnableJdbcRepositories
class CompanyRepositoryAutoConfiguration {
    @Bean
    fun companyRepository(companyJdbcRepository: CompanyJdbcRepository): CompanyRepository {
        return CompanyRepositoryImpl(
            companyJdbcRepository,
        )
    }
}
