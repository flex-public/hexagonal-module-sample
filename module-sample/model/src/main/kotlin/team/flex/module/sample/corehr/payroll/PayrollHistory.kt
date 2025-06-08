package team.flex.module.sample.corehr.payroll

import java.time.Instant

data class PayrollHistory(
    val employeeId: Long,
    val companyId: Long,
    val payrollId: Long,
    val payDatetime: Instant,
    val payrollAmount: Long,
)
