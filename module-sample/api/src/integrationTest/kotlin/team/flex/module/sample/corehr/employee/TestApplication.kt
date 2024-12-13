/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr.employee

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.Clock

@SpringBootApplication(scanBasePackages = ["ignored"])
class TestApplication {
    @Bean
    fun clock() = Clock.systemUTC()
}

fun main(args: Array<String>) {
    runApplication<TestApplication>(*args)
}
