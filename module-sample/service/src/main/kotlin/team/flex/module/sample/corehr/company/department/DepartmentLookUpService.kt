/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.department.repository.DepartmentRepository
import team.flex.module.sample.corehr.exception.DepartmentNotFoundException

interface DepartmentLookUpService {
    fun get(
        companyIdentity: CompanyIdentity,
        departmentIdentity: DepartmentIdentity,
    ): DepartmentModel

    fun getAll(companyIdentity: CompanyIdentity): List<DepartmentModel>
}

internal class DepartmentLookUpServiceImpl(
    private val departmentRepository: DepartmentRepository,
) : DepartmentLookUpService {
    override fun get(
        companyIdentity: CompanyIdentity,
        departmentIdentity: DepartmentIdentity,
    ): DepartmentModel =
        departmentRepository.findByDepartmentIdentity(
            companyIdentity = companyIdentity,
            departmentIdentity = departmentIdentity,
        )
            ?: throw DepartmentNotFoundException()

    override fun getAll(companyIdentity: CompanyIdentity): List<DepartmentModel> =
        departmentRepository.findAllByCompanyIdentity(companyIdentity = companyIdentity)
}
