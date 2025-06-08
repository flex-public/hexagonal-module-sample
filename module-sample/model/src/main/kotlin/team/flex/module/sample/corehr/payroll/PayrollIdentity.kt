package team.flex.module.sample.corehr.payroll

interface PayrollIdentity {
    companion object

    val payrollId: Long
}

internal data class SimplePayrollIdentity(
    override val payrollId: Long,
) : PayrollIdentity

fun PayrollIdentity.Companion.of(payrollId: Long): PayrollIdentity = SimplePayrollIdentity(payrollId)
