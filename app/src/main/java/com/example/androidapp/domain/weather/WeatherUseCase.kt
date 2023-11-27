package com.example.androidapp.domain.weather

import com.example.androidapp.data.WeatherRepository
import com.example.androidapp.data.remote.model.WeatherApiModel
import kotlinx.coroutines.delay

object WeatherUseCase {

    private val repo = WeatherRepository

//    suspend fun getWeather(lat: String = "50.0", lon: String = "30.0"): WeatherApiModel?{

    suspend fun getWeather(lat: String, lon: String): WeatherApiModel?{
        val v = repo.getWeather(lat, lon)
        return v
    }
}