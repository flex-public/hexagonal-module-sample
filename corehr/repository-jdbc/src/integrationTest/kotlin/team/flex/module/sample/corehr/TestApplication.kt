/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Import
import team.flex.module.sample.corehr.company.department.repository.DepartmentRepositoryAutoConfiguration
import team.flex.module.sample.corehr.company.repository.CompanyRepositoryAutoConfiguration
import team.flex.module.sample.corehr.employee.repository.EmployeeRepositoryAutoConfiguration
import java.util.TimeZone

@Import(
    EmployeeRepositoryAutoConfiguration::class,
    CompanyRepositoryAutoConfiguration::class,
    DepartmentRepositoryAutoConfiguration::class,
)
@EnableAutoConfiguration
@SpringBootConfiguration
class TestApplication {
    init {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }
}
