/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department

interface DepartmentIdentity {
    companion object

    val departmentId: Long
}

internal data class SimpleDepartmentIdentity(
    override val departmentId: Long,
) : DepartmentIdentity

fun DepartmentIdentity.Companion.of(departmentId: Long): DepartmentIdentity = SimpleDepartmentIdentity(departmentId)
