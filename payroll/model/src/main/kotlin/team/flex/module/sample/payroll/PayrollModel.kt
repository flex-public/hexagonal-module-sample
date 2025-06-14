package team.flex.module.sample.payroll

import team.flex.module.sample.corehr.AuditProps
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.employee.EmployeeIdentity

interface PayrollProps {
    val id: Long
    val payday: Int
    val payrollAmount: Long
}

interface PayrollModel:
    EmployeeIdentity,
    CompanyIdentity,
    PayrollProps,
    AuditProps
