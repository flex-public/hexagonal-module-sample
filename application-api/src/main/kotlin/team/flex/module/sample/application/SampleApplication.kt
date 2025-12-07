package team.flex.module.sample.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.Clock
import java.util.TimeZone

@SpringBootApplication
class SampleApplication {
    @Bean
    fun clock() = Clock.systemUTC()
}

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    runApplication<SampleApplication>(*args)
}
