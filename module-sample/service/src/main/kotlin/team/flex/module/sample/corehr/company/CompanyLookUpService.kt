/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company

import team.flex.module.sample.corehr.company.repository.CompanyRepository
import team.flex.module.sample.corehr.exception.CompanyNotFoundException

interface CompanyLookUpService {
    fun get(companyIdentity: CompanyIdentity): CompanyModel
}

internal class CompanyLookUpServiceImpl(
    private val companyRepository: CompanyRepository,
) : CompanyLookUpService {
    override fun get(companyIdentity: CompanyIdentity): CompanyModel =
        companyRepository.findByCompanyIdentity(companyIdentity = companyIdentity) ?: throw CompanyNotFoundException()
}
