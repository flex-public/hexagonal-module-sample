package team.flex.module.sample.payroll

import java.time.Instant

data class Payroll(
    override val id: Long,
    override val employeeId: Long,
    override val companyId: Long,
    override val payday: Int,
    override val payrollAmount: Long,
    override val createdAt: Instant,
    override val updatedAt: Instant,
) : PayrollModel
