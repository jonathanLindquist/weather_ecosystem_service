package com.lindquist.weather.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("application")
data class ConfigProps(
    val weather: WeatherProps = WeatherProps(),
    val producer: ProducerProps = ProducerProps(),
) {
    data class WeatherProps(
        val baseUrl: String = ""
    )

    data class ProducerProps(
        val baseUrl: String = ""
    )
}


