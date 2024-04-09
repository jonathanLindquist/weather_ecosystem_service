package com.lindquist.weather.controller

import com.lindquist.weather.dto.Weather
import com.lindquist.weather.service.WeatherService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/weather")
class WeatherController(
    val weatherService: WeatherService
) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }

    @GetMapping("/{city}")
    fun weatherByCity(@PathVariable city: String): Weather {
        logger.info { "Retrieving up weather for $city" }
        return weatherService.weatherByCity(city)
    }
}