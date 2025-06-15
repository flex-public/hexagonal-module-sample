package team.flex.module.sample.payroll.repository

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity
import team.flex.module.sample.payroll.PayrollHistory

@Suppress("ktlint")
interface PayrollHistoryRepository {
    // <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>>
    /**
     * Retrieves a [PayrollHistory] identified by the given [CompanyIdentity] and
     * [EmployeeIdentity].
     *
     * @param companyIdentity the identity of the company
     * @param employeeIdentity the identity of the employee
     * @return the payroll history associated with the given company and employee, or `null` if none.
     */
    // <<<<<<<<<<  e52b93d1-6c93-4e5f-b037-6b031c6633d8  >>>>>>>>>>>

    fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): PayrollHistory?

    fun save(payrollHistory: PayrollHistory): PayrollHistory
}
