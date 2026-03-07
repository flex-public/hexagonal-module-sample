package team.flex.module.sample.payroll.infrastructure.employee

/**
 * payroll 모듈이 필요로 하는 직원 정보의 최소 집합.
 * corehr의 도메인 모델에 직접 의존하지 않기 위한 별도 DTO.
 */
data class EmployeeInfo(
    val employeeId: Long,
    val name: String,
    val department: String,
    val position: String,
)
