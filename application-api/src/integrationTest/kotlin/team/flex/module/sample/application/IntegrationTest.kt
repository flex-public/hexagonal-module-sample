/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.TestConstructor

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class IntegrationTest(private val restTemplate: TestRestTemplate) {
    @Test
    fun test() {
        restTemplate.getForEntity<Any>("/actuator/health/liveness").also {
            assertThat(it.statusCode).isEqualTo(HttpStatus.OK)
        }

        restTemplate.getForEntity<Any>("/actuator/health/readiness").also {
            assertThat(it.statusCode).isEqualTo(HttpStatus.OK)
        }
    }
}
