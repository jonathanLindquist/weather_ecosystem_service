package com.lindquist.weather.client

import com.lindquist.weather.dto.Weather
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class WeatherClient(
    val restClient: RestClient
) {
    val url = "https://goweather.herokuapp.com/weather/"

    fun callByCity(city: String) =
        restClient.get()
            .uri(url + city)
            .retrieve()
            .body(Weather::class.java)
}