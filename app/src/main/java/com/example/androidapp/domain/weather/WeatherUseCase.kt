package com.example.androidapp.domain.weather

import com.example.androidapp.data.CountryRepository
import com.example.androidapp.data.WeatherRepository
import com.example.androidapp.data.local.Country
import com.example.androidapp.data.remote.model.WeatherApiModel
import kotlinx.coroutines.delay

object WeatherUseCase {

    private val repo = WeatherRepository
    private val repo2 = CountryRepository

//    suspend fun getWeather(lat: String = "50.0", lon: String = "30.0"): WeatherApiModel?{

    suspend fun getWeather(lat: String, lon: String): WeatherApiModel?{
        val v = repo.getWeather(lat, lon)

        v?.main?.temp = v?.main?.temp + " °C"

        v?.main?.feels_like = v?.main?.feels_like + " °C"

        v?.main?.pressure = v?.main?.pressure + " mb"

        v?.main?.humidity = v?.main?.humidity + " %"

        return v
    }

    fun getCountry(): List<Country>?{
        val data = repo2.getCountry()
        return data
    }
}