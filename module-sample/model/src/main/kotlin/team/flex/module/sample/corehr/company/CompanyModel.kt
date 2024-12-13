/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company

import team.flex.module.sample.corehr.AuditProps

interface CompanyProps {
    val name: String
}

interface CompanyModel :
    CompanyIdentity,
    CompanyProps,
    AuditProps
