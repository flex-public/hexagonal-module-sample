/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import team.flex.module.sample.corehr.company.department.repository.DepartmentRepository

@AutoConfiguration
class DepartmentAutoConfiguration {
    @Bean
    fun departmentLookUpServiceImpl(departmentRepository: DepartmentRepository): DepartmentLookUpService =
        DepartmentLookUpServiceImpl(
            departmentRepository = departmentRepository,
        )
}
