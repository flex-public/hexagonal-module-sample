/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department.repository

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@AutoConfiguration
@EnableJdbcRepositories
class DepartmentRepositoryAutoConfiguration {
    @Bean
    fun departmentRepository(departmentJdbcRepository: DepartmentJdbcRepository): DepartmentRepository {
        return DepartmentRepositoryImpl(
            departmentJdbcRepository,
        )
    }
}
