package com.lindquist.weather.service

import com.lindquist.weather.client.ProducerServiceClient
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class ProducerService(
    private val producerClient: ProducerServiceClient
) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    fun callHealthCheck() =
        producerClient.callHealthCheck()?.also {
            logger.info { "Health check called" }
        } ?: throw Exception("callHealthCheck failed")
}