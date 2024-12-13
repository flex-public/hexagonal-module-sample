/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.department

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestConstructor
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.department.repository.DepartmentEntity
import team.flex.module.sample.corehr.company.department.repository.DepartmentJdbcRepository
import team.flex.module.sample.corehr.company.department.repository.DepartmentRepository
import team.flex.module.sample.corehr.company.department.repository.DepartmentRepositoryAutoConfiguration
import team.flex.module.sample.corehr.company.of
import java.time.Instant
import java.time.temporal.ChronoUnit

@Import(
    DepartmentRepositoryAutoConfiguration::class,
)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class DepartmentRepositoryIntegrationTest(
    private val cut: DepartmentRepository,
    private val jdbcRepository: DepartmentJdbcRepository,
) {
    @Test
    fun crudTest() {
        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }

        val expected =
            DepartmentEntity(
                companyId = 1L,
                parentDepartmentId = null,
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
            .also {
                it.assert(expected)
            }

        cut.findByDepartmentIdentity(
            companyIdentity = CompanyIdentity.of(expected.companyId),
            departmentIdentity = DepartmentIdentity.of(expected.departmentId),
        )
            .also {
                it!!.assert(expected)
            }

        jdbcRepository.delete(saved)

        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }
    }

    private fun DepartmentModel.assert(other: DepartmentModel) {
        assertThat(companyId).isEqualTo(other.companyId)
        assertThat(name).isEqualTo(other.name)
        assertThat(createdAt).isEqualTo(other.createdAt)
        assertThat(updatedAt).isEqualTo(other.updatedAt)
    }
}
