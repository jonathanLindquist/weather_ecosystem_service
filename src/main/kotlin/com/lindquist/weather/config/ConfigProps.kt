package com.lindquist.weather.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("application")
data class ConfigProps(
    val weather: WeatherProps,
    val producer: ProducerProps,
) {
    data class WeatherProps(
        val baseUrl: String
    )

    data class ProducerProps(
        val baseUrl: String
    )
}


