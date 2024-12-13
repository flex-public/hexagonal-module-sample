/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import team.flex.module.sample.corehr.company.jobrole.JobRoleModel
import java.time.Instant

@Table("job_role")
class JobRoleEntity(
    @Column
    override val companyId: Long,
    @Column
    override var name: String,
    @Column
    override val createdAt: Instant,
    @Column
    override val updatedAt: Instant,
) : JobRoleModel {
    @Id
    var id: Long = 0L

    override val jobRoleId: Long
        get() = id
}
