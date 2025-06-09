/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department

import java.time.Instant

data class Department(
    override val departmentId: Long,
    override val companyId: Long,
    override val parentDepartmentId: Long?,
    override val name: String,
    override val createdAt: Instant,
    override val updatedAt: Instant,
) : DepartmentModel
