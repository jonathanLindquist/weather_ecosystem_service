package com.lindquist.weather.service

import com.lindquist.weather.client.WeatherClient
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class WeatherService(
    val weatherClient: WeatherClient
) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }
    fun weatherByCity(city: String) =
        weatherClient.callByCity(city)!!.also {
            logger.info { "Found weather for $city" }
        }
}