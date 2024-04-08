package com.lindquist.weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class WeatherServiceApplication

fun main(args: Array<String>) {
	runApplication<WeatherServiceApplication>(*args)
}
