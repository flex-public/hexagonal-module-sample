/*
 * Copyright 2024 flex Inc. - All Rights Reserved.
 */

package team.flex.module.sample.corehr

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import java.util.TimeZone

@EnableAutoConfiguration
@SpringBootConfiguration
class TestApplication {
    init {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }
}
