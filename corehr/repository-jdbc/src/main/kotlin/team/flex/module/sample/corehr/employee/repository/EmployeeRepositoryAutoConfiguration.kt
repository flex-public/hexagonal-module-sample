/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee.repository

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@AutoConfiguration
@EnableJdbcRepositories
class EmployeeRepositoryAutoConfiguration {
    @Bean
    fun employeeRepository(employeeJdbcRepository: EmployeeJdbcRepository): EmployeeRepository {
        return EmployeeRepositoryImpl(
            employeeJdbcRepository,
        )
    }
}
