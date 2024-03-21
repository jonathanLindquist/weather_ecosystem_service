package com.lindquist.weather.service

import com.lindquist.weather.client.WeatherClient
import org.springframework.stereotype.Service

@Service
class WeatherService(
    val weatherClient: WeatherClient
) {
    fun weatherByCity(city: String) =
        weatherClient.callByCity(city)!!
}