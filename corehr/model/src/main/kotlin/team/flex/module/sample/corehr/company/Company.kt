/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company

import java.time.Instant

data class Company(
    override val companyId: Long,
    override val name: String,
    override val createdAt: Instant,
    override val updatedAt: Instant,
) : CompanyModel
