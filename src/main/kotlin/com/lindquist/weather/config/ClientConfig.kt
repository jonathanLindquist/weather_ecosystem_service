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

    // Configured via comments from below Github issue, RestClientCustomizer seems best way to wrap global RestClient.Builder
    // https://github.com/spring-projects/spring-ai/issues/354
    // notes on RestClientCustomizer here
    // https://github.com/zhouzxing/spring-boot/blob/f5b3bc7a9fef0573b919fffe573b26209bc16eef/spring-boot-project/spring-boot-docs/src/docs/asciidoc/io/rest-client.adoc#L103
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