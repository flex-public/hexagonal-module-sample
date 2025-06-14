package team.flex.module.sample.payroll.repository

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity
import team.flex.module.sample.payroll.Payroll
import team.flex.module.sample.payroll.PayrollModel

interface PayrollRepository {
    fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): PayrollModel?

    fun save(payroll: Payroll): Payroll
}