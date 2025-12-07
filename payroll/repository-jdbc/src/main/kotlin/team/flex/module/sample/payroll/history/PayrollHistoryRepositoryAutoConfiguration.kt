/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll.history

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Import

@Import(PayrollHistoryRepositoryImpl::class)
@AutoConfiguration
class PayrollHistoryRepositoryAutoConfiguration
