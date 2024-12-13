/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import team.flex.module.sample.corehr.employee.EmployeeModel
import java.time.Instant

@Table("employee")
class EmployeeEntity(
    @Column
    override val companyId: Long,
    @Column
    override val employeeNumber: String,
    @Column
    override var name: String,
    @Column
    override val createdAt: Instant,
    @Column
    override val updatedAt: Instant,
) : EmployeeModel {
    @Id
    var id: Long = 0L

    override val employeeId: Long
        get() = id
}
