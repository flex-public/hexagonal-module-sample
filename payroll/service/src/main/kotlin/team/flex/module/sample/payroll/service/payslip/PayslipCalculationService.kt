package team.flex.module.sample.payroll.service.payslip

import org.springframework.stereotype.Service
import team.flex.module.sample.payroll.infrastructure.employee.EmployeeProvider

/**
 * 급여 명세서 계산 UseCase.
 *
 * EmployeeProvider(Out-Port)를 통해 corehr의 직원 정보를 간접 참조한다.
 * payroll은 corehr 모듈의 구현체를 전혀 알지 못하며,
 * 오직 infrastructure에 정의된 Port 인터페이스만 의존한다.
 */
@Service
class PayslipCalculationService(
    private val employeeProvider: EmployeeProvider,
) {
    /**
     * 특정 직원의 급여 명세서를 생성한다.
     */
    fun calculate(employeeId: Long): PayslipResult {
        val employee =
            employeeProvider.findById(employeeId)
                ?: throw IllegalArgumentException("Employee not found: $employeeId")

        // 실제 급여 계산 로직은 생략 — 모듈 간 통신 패턴 데모 목적
        return PayslipResult(
            employeeId = employee.employeeId,
            employeeName = employee.name,
            department = employee.department,
            baseSalary = 0L,
            totalAmount = 0L,
        )
    }
}
