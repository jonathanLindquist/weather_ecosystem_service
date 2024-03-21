package com.lindquist.weather.dto

data class Weather(
    val temperature: String,
    val wind: String,
    val description: String,
    val forecast: List<Day>
)