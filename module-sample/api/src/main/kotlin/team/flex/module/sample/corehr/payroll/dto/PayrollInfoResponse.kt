package team.flex.module.sample.corehr.payroll.dto

import java.time.Instant

class PayrollInfoResponse(
    val employeeId: Long,
    val companyId: Long,
    val payday: Int,
    val payrollAmount: Long,
    val createdAt: Instant,
    val updatedAt: Instant,
)