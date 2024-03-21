package com.lindquist.weather.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class WeatherConfig {
    @Bean
    fun restCLient() =
        RestClient.builder().build()
}