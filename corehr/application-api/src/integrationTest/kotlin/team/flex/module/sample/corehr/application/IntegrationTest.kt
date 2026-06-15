/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.resttestclient.TestRestTemplate
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate
import org.springframework.boot.resttestclient.getForEntity
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.TestConstructor

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
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

        // springdoc(swagger)이 OpenAPI 문서를 실제로 직렬화할 수 있는지 검증한다.
        // 이 호출은 swagger-core의 Jackson 직렬화 경로를 실행시키므로,
        // 의존성 정리로 Jackson 클래스가 누락되면 여기서 실패한다.
        restTemplate.getForEntity<String>("/v3/api-docs/corehr").also {
            assertThat(it.statusCode).isEqualTo(HttpStatus.OK)
            assertThat(it.body).contains("\"openapi\"")
        }
    }
}
