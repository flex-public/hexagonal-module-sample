/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.payroll

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity
import team.flex.module.sample.corehr.exception.EmployeeNotFoundException
import java.time.Instant

interface PayrollService {
    fun getHistory(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): PayrollHistory?

    fun addPayrollInfo(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
        payrollAmount: Long,
        payDay: Int,
    ): Payroll

    // TODO: updatePayrollInfo 기능 추가 필요

    fun pay(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): PayrollHistory
}

internal class PayrollServiceImpl(
    private val payrollRepository: PayrollRepository,
    private val payrollHistoryRepository: PayrollHistoryRepository,
) : PayrollService {
    override fun getHistory(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity
    ): PayrollHistory? {
        return payrollHistoryRepository.findByEmployeeIdentity(
            companyIdentity = companyIdentity,
            employeeIdentity = employeeIdentity,
        )
    }

    override fun addPayrollInfo(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
        payrollAmount: Long,
        payDay: Int
    ): Payroll {
        return payrollRepository.save(
            Payroll(
                id = 0L,
                employeeId = employeeIdentity.employeeId,
                companyId = companyIdentity.companyId,
                payday = payDay,
                payrollAmount = payrollAmount,
                createdAt = Instant.now(),
                updatedAt = Instant.now(),
            )
        )
    }

    override fun pay(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): PayrollHistory {
        val now = Instant.now()
        val payrollInfo = payrollRepository.findByEmployeeIdentity(
            companyIdentity = companyIdentity,
            employeeIdentity = employeeIdentity,
        ) ?: throw EmployeeNotFoundException()

        return try {
            payrollHistoryRepository.save(
                PayrollHistory(
                    employeeId = employeeIdentity.employeeId,
                    companyId = companyIdentity.companyId,
                    payrollId = payrollInfo.id,
                    payDatetime = now,
                    payrollAmount = payrollInfo.payrollAmount,
                )
            )
        } catch (e: Exception) {
            throw RuntimeException("Failed to process payroll for employee ${employeeIdentity.employeeId} at company ${companyIdentity.companyId}", e)
        }
    }
}
