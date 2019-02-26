package org.craftsrecords.talkadvisorconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TalkAdvisorConsumerApplication

fun main(args: Array<String>) {
	runApplication<TalkAdvisorConsumerApplication>(*args)
}
