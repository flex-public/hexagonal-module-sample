/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll.history

import org.springframework.data.repository.CrudRepository
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity
import team.flex.module.sample.payroll.PayrollHistory
import team.flex.module.sample.payroll.repository.PayrollHistoryRepository

interface PayrollHistoryJdbcRepository : CrudRepository<PayrollHistoryEntity, Long> {
    fun findByEmployeeIdAndCompanyId(
        employeeId: Long,
        companyId: Long,
    ): PayrollHistoryEntity?
}

class PayrollHistoryRepositoryImpl(
    private val payrollHistoryJdbcRepository: PayrollHistoryJdbcRepository,
) : PayrollHistoryRepository {
    private fun PayrollHistoryEntity.toModel() =
        PayrollHistory(
            employeeId = employeeId,
            companyId = companyId,
            payrollId = payrollId,
            payDatetime = payDatetime,
            payrollAmount = payrollAmount,
        )

    override fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity
    ): PayrollHistory? {
        return payrollHistoryJdbcRepository.findByEmployeeIdAndCompanyId(
            employeeId = employeeIdentity.employeeId,
            companyId = companyIdentity.companyId,
        )?.toModel()
    }

    override fun save(payrollHistory: PayrollHistory): PayrollHistory {
        val entity = PayrollHistoryEntity(
            employeeId = payrollHistory.employeeId,
            companyId = payrollHistory.companyId,
            payrollId = payrollHistory.payrollId,
            payDatetime = payrollHistory.payDatetime,
            payrollAmount = payrollHistory.payrollAmount,
        )
        return payrollHistoryJdbcRepository.save(entity).toModel()
    }
}
