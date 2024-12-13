/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company

interface CompanyIdentity {
    companion object

    val companyId: Long
}

internal data class SimpleCompanyIdentity(
    override val companyId: Long,
) : CompanyIdentity

fun CompanyIdentity.Companion.of(companyId: Long): CompanyIdentity = SimpleCompanyIdentity(companyId)
