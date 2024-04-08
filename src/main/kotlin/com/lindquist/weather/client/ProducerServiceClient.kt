package com.lindquist.weather.client

import com.lindquist.weather.config.ConfigProps
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class ProducerServiceClient(
    val restClient: RestClient,
    val configProps: ConfigProps
) {
   fun callHealthCheck() =
       restClient.get()
           .uri(configProps.producer.baseUrl + "health")
           .retrieve()
           .onStatus(HttpStatusCode::is4xxClientError) {_, response ->
               throw Exception("callHealthCheck failed: ${response.statusCode}")
           }
           .body(String::class.java)
}