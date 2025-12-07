/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.payroll

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.of
import team.flex.module.sample.corehr.employee.EmployeeIdentity
import team.flex.module.sample.corehr.employee.of
import team.flex.module.sample.payroll.dto.PayRequest
import team.flex.module.sample.payroll.dto.PayrollHistoryResponse
import team.flex.module.sample.payroll.dto.PayrollInfoRequest
import team.flex.module.sample.payroll.dto.PayrollInfoResponse

@RestController
@RequestMapping("/api/v2/payroll")
class PayrollApiController(
    private val service: PayrollService,
) {
    @GetMapping("/companies/{companyId}/employees/{employeeId}")
    @Operation(
        summary = "급여 지급 기록 조회 API",
        operationId = "getPayrollHistoryByEmployeeId",
    )
    fun getPayrollHistoryByEmployeeId(
        @PathVariable companyId: Long,
        @PathVariable employeeId: Long,
    ): PayrollHistoryResponse {
        return service.getHistory(
            CompanyIdentity.of(companyId),
            EmployeeIdentity.Companion.of(employeeId),
        ).let {
            if (it == null) {
                PayrollHistoryResponse.NotExist
            } else {
                PayrollHistoryResponse.Exist(
                    employeeId = it.employeeId,
                    companyId = it.companyId,
                    payDatetime = it.payDatetime,
                    payrollAmount = it.payrollAmount,
                )
            }
        }
    }

    @PostMapping
    @Operation(
        summary = "급여 정보 저장 API",
        operationId = "savePayrollInfo",
    )
    fun savePayrollInfo(
        @RequestBody request: PayrollInfoRequest,
    ): PayrollInfoResponse {
        return service.addPayrollInfo(
            companyIdentity = CompanyIdentity.of(request.companyId),
            employeeIdentity = EmployeeIdentity.Companion.of(request.employeeId),
            payrollAmount = request.payrollAmount,
            payDay = request.payday,
        ).let {
            PayrollInfoResponse(
                employeeId = it.employeeId,
                companyId = it.companyId,
                payday = it.payday,
                payrollAmount = it.payrollAmount,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt,
            )
        }
    }

    @PostMapping("/pay")
    @Operation(
        summary = "급여 지급 API",
        operationId = "pay",
    )
    fun pay(
        @RequestBody request: PayRequest,
    ): PayrollHistoryResponse {
        return service.pay(
            CompanyIdentity.of(request.companyId),
            EmployeeIdentity.Companion.of(request.employeeId),
        ).let {
            PayrollHistoryResponse.Exist(
                employeeId = it.employeeId,
                companyId = it.companyId,
                payDatetime = it.payDatetime,
                payrollAmount = it.payrollAmount,
            )
        }
    }
}
