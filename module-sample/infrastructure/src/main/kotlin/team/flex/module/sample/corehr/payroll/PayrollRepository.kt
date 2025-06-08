package team.flex.module.sample.corehr.payroll

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity

interface PayrollRepository {
    fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): PayrollModel?

    fun save(payroll: Payroll): Payroll
}