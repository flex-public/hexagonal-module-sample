/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee.repository

import org.springframework.data.repository.CrudRepository
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.Employee
import team.flex.module.sample.corehr.employee.EmployeeIdentity
import team.flex.module.sample.corehr.employee.EmployeeModel

interface EmployeeJdbcRepository : CrudRepository<EmployeeEntity, Long> {
    fun findByIdAndCompanyId(
        employeeId: Long,
        companyId: Long,
    ): EmployeeEntity?

    fun findByCompanyId(companyId: Long): List<EmployeeEntity>
}

class EmployeeRepositoryImpl(
    private val employeeJdbcRepository: EmployeeJdbcRepository,
) : EmployeeRepository {
    override fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): EmployeeModel? {
        return employeeJdbcRepository.findByIdAndCompanyId(
            employeeId = employeeIdentity.employeeId,
            companyId = companyIdentity.companyId,
        )?.toModel()
    }

    override fun findAllByCompanyIdentity(companyIdentity: CompanyIdentity): List<EmployeeModel> {
        return employeeJdbcRepository.findByCompanyId(
            companyId = companyIdentity.companyId,
        ).map { it.toModel() }
    }

    private fun EmployeeEntity.toModel() =
        Employee(
            employeeId = employeeId,
            companyId = companyId,
            employeeNumber = employeeNumber,
            name = name,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
}
