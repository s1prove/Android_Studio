package com.example.androidapp.data.remote.model

data class WeatherApiModel (
    val lon: Float?,
    val lat: Float?,
    val timezone: String?,
    val current: CurrentWeatherApiModel
)