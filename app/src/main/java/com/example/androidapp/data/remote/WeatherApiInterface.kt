package com.example.androidapp.data.remote

import com.example.androidapp.data.remote.model.WeatherApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherApiInterface {


    @GET("weather")
    suspend fun getWeather(@QueryMap params: Map<String, String>): Response<WeatherApiModel>
}