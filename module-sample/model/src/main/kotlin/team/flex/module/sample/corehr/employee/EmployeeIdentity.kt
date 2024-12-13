/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee

interface EmployeeIdentity {
    companion object

    val employeeId: Long
}

internal data class SimpleEmployeeIdentity(
    override val employeeId: Long,
) : EmployeeIdentity

fun EmployeeIdentity.Companion.of(employeeId: Long): EmployeeIdentity = SimpleEmployeeIdentity(employeeId)
