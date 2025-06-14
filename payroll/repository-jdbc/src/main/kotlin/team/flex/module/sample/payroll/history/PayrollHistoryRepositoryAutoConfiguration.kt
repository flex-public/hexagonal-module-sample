/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll.history

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@AutoConfiguration
@EnableJdbcRepositories
class PayrollHistoryRepositoryAutoConfiguration {
    @Bean
    fun payrollHistoryRepository(payrollHistoryJdbcRepository: PayrollHistoryJdbcRepository): PayrollHistoryRepositoryImpl {
        return PayrollHistoryRepositoryImpl(
            payrollHistoryJdbcRepository,
        )
    }
}
