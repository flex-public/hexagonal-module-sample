/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole

import java.time.Instant

data class JobRole(
    override val jobRoleId: Long,
    override val companyId: Long,
    override val name: String,
    override val createdAt: Instant,
    override val updatedAt: Instant,
) : JobRoleModel
