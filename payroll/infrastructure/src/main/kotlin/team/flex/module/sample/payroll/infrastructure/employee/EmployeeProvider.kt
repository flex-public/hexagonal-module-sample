package team.flex.module.sample.payroll.infrastructure.employee

/**
 * 모듈 간 통신을 위한 Out-Port.
 * payroll 도메인이 corehr의 Employee 정보를 조회할 때 사용한다.
 *
 * 이 인터페이스는 payroll/infrastructure에 정의되어
 * payroll이 corehr의 구현 세부사항을 알지 못하게 한다.
 * 실제 구현체(Adapter)는 application-api 조립 시점에 주입된다.
 */
interface EmployeeProvider {
    /**
     * 사번으로 직원 정보를 조회한다.
     * @return 직원 정보 (없으면 null)
     */
    fun findById(employeeId: Long): EmployeeInfo?

    /**
     * 전체 재직 중인 직원 목록을 조회한다.
     */
    fun findAllActive(): List<EmployeeInfo>
}
