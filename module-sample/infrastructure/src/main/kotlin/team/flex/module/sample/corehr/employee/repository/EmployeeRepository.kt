/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee.repository

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity
import team.flex.module.sample.corehr.employee.EmployeeModel

interface EmployeeRepository {
    fun findByEmployeeIdentity(
        companyIdentity: CompanyIdentity,
        employeeIdentity: EmployeeIdentity,
    ): EmployeeModel?

    fun findAllByCompanyIdentity(companyIdentity: CompanyIdentity): List<EmployeeModel>
}
