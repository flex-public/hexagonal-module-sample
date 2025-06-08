package team.flex.module.sample.corehr.payroll

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity

interface PayrollHistoryRepository {
    fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): PayrollHistory?

    fun save(payrollHistory: PayrollHistory): PayrollHistory
}