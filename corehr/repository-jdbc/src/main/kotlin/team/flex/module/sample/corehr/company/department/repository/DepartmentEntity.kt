/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import team.flex.module.sample.corehr.company.department.DepartmentModel
import java.time.Instant

@Table("department")
class DepartmentEntity(
    @Column
    override val companyId: Long,
    @Column("parent_id")
    override val parentDepartmentId: Long?,
    @Column
    override var name: String,
    @Column
    override val createdAt: Instant,
    @Column
    override val updatedAt: Instant,
) : DepartmentModel {
    @Id
    var id: Long = 0L

    override val departmentId: Long
        get() = id
}
