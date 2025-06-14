/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("payroll")
class PayrollEntity(
    @Id
    override var id: Long = 0L,
    @Column
    override val companyId: Long,
    @Column
    override val employeeId: Long,
    @Column
    override var payday: Int,
    @Column
    override var payrollAmount: Long,
) : PayrollModel {

    @Column
    override val createdAt: Instant = Instant.now()
    @Column
    override val updatedAt: Instant = Instant.now()
}
