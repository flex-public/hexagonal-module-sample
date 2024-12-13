/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole

interface JobRoleIdentity {
    companion object

    val jobRoleId: Long
}

internal data class SimpleJobRoleIdentity(
    override val jobRoleId: Long,
) : JobRoleIdentity

fun JobRoleIdentity.Companion.of(jobRoleId: Long): JobRoleIdentity = SimpleJobRoleIdentity(jobRoleId)
