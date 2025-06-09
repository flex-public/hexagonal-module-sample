/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.jobrole.repository.JobRoleRepository
import team.flex.module.sample.corehr.exception.JobRoleNotFoundException

interface JobRoleLookUpService {
    fun get(
        companyIdentity: CompanyIdentity,
        jobRoleIdentity: JobRoleIdentity,
    ): JobRoleModel

    fun getAll(companyIdentity: CompanyIdentity): List<JobRoleModel>
}

internal class JobRoleLookUpServiceImpl(
    private val jobRoleRepository: JobRoleRepository,
) : JobRoleLookUpService {
    override fun get(
        companyIdentity: CompanyIdentity,
        jobRoleIdentity: JobRoleIdentity,
    ): JobRoleModel =
        jobRoleRepository.findByJobRoleIdentity(
            companyIdentity = companyIdentity,
            jobRoleIdentity = jobRoleIdentity,
        ) ?: throw JobRoleNotFoundException()

    override fun getAll(companyIdentity: CompanyIdentity): List<JobRoleModel> =
        jobRoleRepository.findAllByCompanyIdentity(companyIdentity = companyIdentity)
}
