/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole.repository

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@AutoConfiguration
@EnableJdbcRepositories
class JobRoleRepositoryAutoConfiguration {
    @Bean
    fun jobRoleRepository(jobRoleJdbcRepository: JobRoleJdbcRepository): JobRoleRepository {
        return JobRoleRepositoryImpl(
            jobRoleJdbcRepository,
        )
    }
}
