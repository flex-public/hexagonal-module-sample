/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestConstructor
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.of
import team.flex.module.sample.corehr.employee.repository.EmployeeEntity
import team.flex.module.sample.corehr.employee.repository.EmployeeJdbcRepository
import team.flex.module.sample.corehr.employee.repository.EmployeeRepository
import team.flex.module.sample.corehr.employee.repository.EmployeeRepositoryAutoConfiguration
import java.time.Instant
import java.time.temporal.ChronoUnit

@Import(
    EmployeeRepositoryAutoConfiguration::class,
)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class EmployeeRepositoryIntegrationTest(
    private val cut: EmployeeRepository,
    private val jdbcRepository: EmployeeJdbcRepository,
) {
    @Test
    fun crudTest() {
        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }

        val expected =
            EmployeeEntity(
                companyId = 1,
                employeeNumber = "TEST_10001",
                name = "name",
                createdAt = Instant.now().truncatedTo(ChronoUnit.SECONDS),
                updatedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS),
            )

        val saved =
            jdbcRepository.save(expected).also {
                assertThat(it.id).isNotZero()
            }

        cut.findAllByCompanyIdentity(
            companyIdentity = CompanyIdentity.of(expected.companyId),
        )
            .also { assertThat(it).hasSize(1) }
            .first()
            .also { actual ->
                actual.assert(expected)
            }

        cut.findByEmployeeIdentity(
            companyIdentity = CompanyIdentity.of(expected.companyId),
            employeeIdentity = EmployeeIdentity.of(expected.employeeId),
        )
            .also { actual ->
                actual!!.assert(expected)
            }

        jdbcRepository.delete(saved)

        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }
    }

    private fun EmployeeModel.assert(expected: EmployeeModel) {
        assertThat(companyId).isEqualTo(expected.companyId)
        assertThat(employeeNumber).isEqualTo(expected.employeeNumber)
        assertThat(name).isEqualTo(expected.name)
        assertThat(createdAt).isEqualTo(expected.createdAt)
        assertThat(updatedAt).isEqualTo(expected.updatedAt)
    }
}
