package team.flex.module.sample.payroll.dto

import java.time.Instant

sealed class PayrollHistoryResponse(
    val type: ResponseType,
) {
    enum class ResponseType {
        EXIST,
        NOT_EXIST,
    }

    data class Exist(
        val employeeId: Long,
        val companyId: Long,
        val payDatetime: Instant,
        val payrollAmount: Long,
    ) : PayrollHistoryResponse(ResponseType.EXIST)

    object NotExist : PayrollHistoryResponse(ResponseType.NOT_EXIST)
}
