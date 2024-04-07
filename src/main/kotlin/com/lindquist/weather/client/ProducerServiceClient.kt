package com.lindquist.weather.client

import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class ProducerServiceClient(
    val restClient: RestClient
) {
   val url = "http://localhost:8080/v1/weather/producer/"

   fun callHealthCheck() =
       restClient.get()
           .uri(url + "health")
           .retrieve()
           .body(String::class.java)
}