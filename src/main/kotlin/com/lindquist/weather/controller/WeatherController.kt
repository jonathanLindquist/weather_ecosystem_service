package com.lindquist.weather.controller

import com.lindquist.weather.dto.Weather
import com.lindquist.weather.service.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/weather")
class WeatherController(
    val weatherService: WeatherService
) {
    @GetMapping("/{city}")
    fun weatherByCity(@PathVariable city: String): Weather {
        return weatherService.weatherByCity(city)
    }
}