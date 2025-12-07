/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Import
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@Import(PayrollRepositoryImpl::class)
@AutoConfiguration
@EnableJdbcRepositories
class PayrollRepositoryAutoConfiguration
