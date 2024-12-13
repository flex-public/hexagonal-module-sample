/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.company

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestConstructor
import team.flex.module.sample.corehr.company.repository.CompanyEntity
import team.flex.module.sample.corehr.company.repository.CompanyJdbcRepository
import team.flex.module.sample.corehr.company.repository.CompanyRepository
import team.flex.module.sample.corehr.company.repository.CompanyRepositoryAutoConfiguration
import java.time.Instant
import java.time.temporal.ChronoUnit

@Import(
    CompanyRepositoryAutoConfiguration::class,
)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CompanyRepositoryIntegrationTest(
    private val cut: CompanyRepository,
    private val jdbcRepository: CompanyJdbcRepository,
) {
    @Test
    fun crudTest() {
        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }

        val expected =
            CompanyEntity(
                name = "name",
                createdAt = Instant.now().truncatedTo(ChronoUnit.SECONDS),
                updatedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS),
            )

        val saved =
            jdbcRepository.save(expected).also {
                assertThat(it.id).isNotZero()
            }

        cut.findByCompanyIdentity(
            companyIdentity = CompanyIdentity.of(expected.companyId),
        )
            .also {
                assertThat(it!!.name).isEqualTo(expected.name)
                assertThat(it.createdAt).isEqualTo(expected.createdAt)
                assertThat(it.updatedAt).isEqualTo(expected.updatedAt)
            }

        jdbcRepository.delete(saved)

        jdbcRepository.findAll().also {
            assertThat(it).isEmpty()
        }
    }
}
