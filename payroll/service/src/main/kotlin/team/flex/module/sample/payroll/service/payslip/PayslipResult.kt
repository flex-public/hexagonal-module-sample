package team.flex.module.sample.payroll.service.payslip

/**
 * 급여 명세서 계산 결과.
 */
data class PayslipResult(
    val employeeId: Long,
    val employeeName: String,
    val department: String,
    val baseSalary: Long,
    val totalAmount: Long,
)
