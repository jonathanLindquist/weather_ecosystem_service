package com.lindquist.weather.controller

import com.lindquist.weather.service.ProducerService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/weather/producer")
class ProducerController(
    private val producerService: ProducerService
) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    @GetMapping("/health")
    fun healthCheck(): String {
        logger.info { "Producer health check" }
        return producerService.callHealthCheck()
    }
}