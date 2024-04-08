package com.lindquist.weather.client

import com.lindquist.weather.config.ConfigProps
import com.lindquist.weather.dto.Weather
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class WeatherClient(
    val restClient: RestClient,
    val configProps: ConfigProps
) {
    fun callByCity(city: String) =
        restClient.get()
            .uri(configProps.weather.baseUrl + city)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError) { _, response ->
                throw Exception("City retrieval failed: ${response.statusCode}")
            }
            .body(Weather::class.java)
}