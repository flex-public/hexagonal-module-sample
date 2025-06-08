/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.payroll

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean

@AutoConfiguration
class PayrollAutoConfiguration {
    @Bean
    fun payrollServiceImpl(payrollRepository: PayrollRepository, payrollHistoryRepository: PayrollHistoryRepository): PayrollService =
        PayrollServiceImpl(
            payrollRepository = payrollRepository,
            payrollHistoryRepository = payrollHistoryRepository,
        )
}
