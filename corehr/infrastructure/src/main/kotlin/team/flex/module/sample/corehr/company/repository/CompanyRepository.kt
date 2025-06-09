/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.repository

import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.CompanyModel

interface CompanyRepository {
    fun findByCompanyIdentity(companyIdentity: CompanyIdentity): CompanyModel?
}
