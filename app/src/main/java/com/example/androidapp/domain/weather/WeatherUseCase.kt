package com.example.androidapp.domain.weather

import com.example.androidapp.data.WeatherRepository
import kotlinx.coroutines.delay

object WeatherUseCase {

    private val repo = WeatherRepository

    suspend fun getWeather(lat: String = "50.0", lon: String = "30.0"): String{

        val v = repo.getWeather(lat, lon)
        return v.toString()
    }
}