/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.payroll

import org.springframework.data.repository.CrudRepository
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity

interface PayrollJdbcRepository : CrudRepository<PayrollEntity, Long> {
    fun findByEmployeeIdAndCompanyId(
        employeeId: Long,
        companyId: Long,
    ): PayrollEntity?
}

class PayrollRepositoryImpl(
    private val payrollJdbcRepository: PayrollJdbcRepository,
) : PayrollRepository {
    private fun PayrollEntity.toModel() =
        Payroll(
            id = id,
            employeeId = employeeId,
            companyId = companyId,
            payday = payday,
            payrollAmount = payrollAmount,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )

    override fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity
    ): PayrollModel? {
        return payrollJdbcRepository.findByEmployeeIdAndCompanyId(
            employeeId = employeeIdentity.employeeId,
            companyId = companyIdentity.companyId,
        )?.toModel()
    }

    override fun save(payroll: Payroll): Payroll {
        return payrollJdbcRepository.save(
            PayrollEntity(
                companyId = payroll.companyId,
                employeeId = payroll.employeeId,
                payday = payroll.payday,
                payrollAmount = payroll.payrollAmount,
            )
        ).toModel()
    }
}
