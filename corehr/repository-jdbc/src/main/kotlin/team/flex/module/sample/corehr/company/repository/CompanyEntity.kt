/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.repository

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import team.flex.module.sample.corehr.company.CompanyModel
import java.time.Instant

@Table("company")
class CompanyEntity(
    @Column
    override var name: String,
    @Column
    override val createdAt: Instant,
    @Column
    override val updatedAt: Instant,
) : CompanyModel {
    @Id
    var id: Long = 0L

    override val companyId: Long
        get() = id
}
