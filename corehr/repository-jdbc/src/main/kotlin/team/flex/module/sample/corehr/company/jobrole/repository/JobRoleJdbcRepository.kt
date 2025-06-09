/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole.repository

import org.springframework.data.repository.CrudRepository
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.jobrole.JobRole
import team.flex.module.sample.corehr.company.jobrole.JobRoleIdentity
import team.flex.module.sample.corehr.company.jobrole.JobRoleModel

interface JobRoleJdbcRepository : CrudRepository<JobRoleEntity, Long> {
    fun findByIdAndCompanyId(
        jobRoleId: Long,
        companyId: Long,
    ): JobRoleEntity?

    fun findAllByCompanyId(companyId: Long): List<JobRoleEntity>
}

class JobRoleRepositoryImpl(
    private val jobRoleJdbcRepository: JobRoleJdbcRepository,
) : JobRoleRepository {
    override fun findByJobRoleIdentity(
        companyIdentity: CompanyIdentity,
        jobRoleIdentity: JobRoleIdentity,
    ): JobRoleModel? {
        return jobRoleJdbcRepository.findByIdAndCompanyId(
            jobRoleId = jobRoleIdentity.jobRoleId,
            companyId = companyIdentity.companyId,
        )?.toModel()
    }

    override fun findAllByCompanyIdentity(companyIdentity: CompanyIdentity): List<JobRoleModel> {
        return jobRoleJdbcRepository.findAllByCompanyId(
            companyId = companyIdentity.companyId,
        ).map { it.toModel() }
    }

    private fun JobRoleEntity.toModel() =
        JobRole(
            jobRoleId = jobRoleId,
            companyId = companyId,
            name = name,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
}
