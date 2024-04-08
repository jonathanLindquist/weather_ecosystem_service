package com.lindquist.weather.config

import org.springframework.boot.web.client.ClientHttpRequestFactories
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings
import org.springframework.boot.web.client.RestClientCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import java.time.Duration


@Configuration
class ClientConfig(
    val restClientBuilder: RestClient.Builder
) {
    @Bean
    fun restClient(): RestClient {
        restClientCustomizer().customize(restClientBuilder)
        return restClientBuilder.build()
    }

    fun restClientCustomizer(): RestClientCustomizer {
        return RestClientCustomizer { restClientBuilder: RestClient.Builder ->
            restClientBuilder
                .requestFactory(
                    ClientHttpRequestFactories.get(
                        ClientHttpRequestFactorySettings.DEFAULTS
                            .withConnectTimeout(Duration.ofSeconds(1))
                            .withReadTimeout(Duration.ofSeconds(2))
                    )
                )
        }
    }
}