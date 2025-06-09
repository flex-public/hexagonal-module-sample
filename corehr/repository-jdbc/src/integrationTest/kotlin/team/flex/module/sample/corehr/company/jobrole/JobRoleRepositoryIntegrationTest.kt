/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company.jobrole

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestConstructor
import team.flex.module.sample.corehr.company.CompanyIdentity
import team.flex.module.sample.corehr.company.jobrole.repository.JobRoleEntity
import team.flex.module.sample.corehr.company.jobrole.repository.JobRoleJdbcRepository
import team.flex.module.sample.corehr.company.jobrole.repository.JobRoleRepository
import team.flex.module.sample.corehr.company.jobrole.repository.JobRoleRepositoryAutoConfiguration
import team.flex.module.sample.corehr.company.of
import java.time.Instant
import java.time.temporal.ChronoUnit

@Import(
    JobRoleRepositoryAutoConfiguration::class,
)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class JobRoleRepositoryIntegrationTest(
    private val cut: JobRoleRepository,
    private val jdbcRepository: JobRoleJdbcRepository,
) {
    @Test
    fun crudTest() {
        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }

        val expected =
            JobRoleEntity(
                companyId = 1L,
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

        cut.findByJobRoleIdentity(
            companyIdentity = CompanyIdentity.of(expected.companyId),
            jobRoleIdentity = JobRoleIdentity.of(expected.jobRoleId),
        )
            .also {
                it!!.assert(expected)
            }

        jdbcRepository.delete(saved)

        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }
    }

    private fun JobRoleModel.assert(expected: JobRoleModel) {
        assertThat(companyId).isEqualTo(expected.companyId)
        assertThat(name).isEqualTo(expected.name)
        assertThat(createdAt).isEqualTo(expected.createdAt)
        assertThat(updatedAt).isEqualTo(expected.updatedAt)
    }
}
