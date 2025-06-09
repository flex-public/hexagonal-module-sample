/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department

import team.flex.module.sample.corehr.AuditProps
import team.flex.module.sample.corehr.company.CompanyIdentity

interface DepartmentProps {
    val name: String
}

interface ParentDepartmentRelationIdentity {
    val parentDepartmentId: Long?
}

interface DepartmentModel :
    DepartmentIdentity,
    ParentDepartmentRelationIdentity,
    CompanyIdentity,
    DepartmentProps,
    AuditProps
