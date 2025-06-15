/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import team.flex.module.sample.payroll.repository.PayrollRepository

@AutoConfiguration
@EnableJdbcRepositories
class PayrollRepositoryAutoConfiguration {
    @Bean
    fun payrollRepository(payrollJdbcRepository: PayrollJdbcRepository): PayrollRepository {
        return PayrollRepositoryImpl(
            payrollJdbcRepository,
        )
    }
}
