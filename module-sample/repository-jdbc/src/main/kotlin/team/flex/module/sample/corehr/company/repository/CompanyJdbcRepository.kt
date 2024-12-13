/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import team.flex.module.sample.corehr.company.Company
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.CompanyModel

interface CompanyJdbcRepository : CrudRepository<CompanyEntity, Long>

class CompanyRepositoryImpl(
    private val companyJdbcRepository: CompanyJdbcRepository,
) : CompanyRepository {
    override fun findByCompanyIdentity(companyIdentity: CompanyIdentity): CompanyModel? {
        return companyJdbcRepository.findByIdOrNull(id = companyIdentity.companyId)?.toModel()
    }

    private fun CompanyEntity.toModel() =
        Company(
            companyId = companyId,
            name = name,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
}
