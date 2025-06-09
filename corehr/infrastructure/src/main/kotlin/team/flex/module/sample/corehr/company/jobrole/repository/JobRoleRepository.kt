/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole.repository

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.jobrole.JobRoleIdentity
import team.flex.module.sample.corehr.company.jobrole.JobRoleModel

interface JobRoleRepository {
    fun findByJobRoleIdentity(
        companyIdentity: CompanyIdentity,
        jobRoleIdentity: JobRoleIdentity,
    ): JobRoleModel?

    fun findAllByCompanyIdentity(companyIdentity: CompanyIdentity): List<JobRoleModel>
}
