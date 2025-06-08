package team.flex.module.sample.corehr.payroll.history

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("payroll_history")
class PayrollHistoryEntity(
    @Column
    val employeeId: Long,
    @Column
    val companyId: Long,
    @Column
    val payrollId: Long,
    @Column
    val payDatetime: Instant,
    @Column
    val payrollAmount: Long,
) {
    @Id
    var id: Long = 0L

    @Column
    val createdAt: Instant = Instant.now()
}