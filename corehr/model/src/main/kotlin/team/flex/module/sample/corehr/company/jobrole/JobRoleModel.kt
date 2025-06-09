/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole

import team.flex.module.sample.corehr.AuditProps
import team.flex.module.sample.corehr.company.CompanyIdentity

interface JobRoleProps {
    val name: String
}

interface JobRoleModel :
    JobRoleIdentity,
    CompanyIdentity,
    JobRoleProps,
    AuditProps
