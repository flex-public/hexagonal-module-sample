package team.flex.module.sample.payroll.dto

class PayrollInfoRequest(
    val employeeId: Long,
    val companyId: Long,
    val payday: Int,
    val payrollAmount: Long,
)
