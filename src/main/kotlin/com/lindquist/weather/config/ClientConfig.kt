package com.lindquist.weather.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestClient


@Configuration
class ClientConfig {
    @Bean
    fun restClient() =
        RestClient.builder()
            .requestFactory(getClientHttpRequestFactory())
            .build()

    fun getClientHttpRequestFactory(): ClientHttpRequestFactory {
        val clientHttpRequestFactory = HttpComponentsClientHttpRequestFactory()
        clientHttpRequestFactory.setConnectTimeout(2000)
        clientHttpRequestFactory.setConnectionRequestTimeout(700)
        return clientHttpRequestFactory
    }
}