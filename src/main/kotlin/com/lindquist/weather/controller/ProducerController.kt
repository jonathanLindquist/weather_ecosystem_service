package com.lindquist.weather.controller

import com.lindquist.weather.service.ProducerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/producer")
class ProducerController(
    private val producerService: ProducerService
) {
    @GetMapping("/health")
    fun healthCheck(): String {
        //TODO: debug infinite loop when can't reach endpoint
//        val restTemplate = RestTemplate()
//        return restTemplate.getForEntity("http://localhost:8080/v1/producer/health", String::class.java).body ?: ""
        return producerService.callHealthCheck()
    }
}