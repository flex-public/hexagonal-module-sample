/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee

import team.flex.module.sample.corehr.AuditProps
import team.flex.module.sample.corehr.company.CompanyIdentity

interface EmployeeProps {
    val employeeNumber: String
    val name: String
}

interface EmployeeModel :
    EmployeeIdentity,
    CompanyIdentity,
    EmployeeProps,
    AuditProps
