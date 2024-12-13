/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee

import java.time.Instant

data class Employee(
    override val employeeId: Long,
    override val companyId: Long,
    override val employeeNumber: String,
    override val name: String,
    override val createdAt: Instant,
    override val updatedAt: Instant,
) : EmployeeModel
