package com.lindquist.weather.service

import com.lindquist.weather.client.ProducerServiceClient
import org.springframework.stereotype.Service

@Service
class ProducerService(
    private val producerClient: ProducerServiceClient
) {
    fun callHealthCheck() =
        producerClient.callHealthCheck() ?: throw Exception("callHealthCheck failed")
}