package com.example.androidapp.data

import com.example.androidapp.data.remote.ApiFactory
import com.example.androidapp.data.remote.model.WeatherApiModel

object WeatherRepository {

    private val api = ApiFactory.weatherApi
    private val API_KEY = "4ee42fb04770cf4cde4aa93b723e196e"


//    suspend fun getWeather(lat: String = "48.0", lon: String = "35.0"): WeatherApiModel?{

    suspend fun getWeather(lat: String, lon: String): WeatherApiModel?{
        val params = HashMap<String, String>()
        params.put("lat", lat)
        params.put("lon", lon)
        params.put("appid", API_KEY)
        params.put("units", "metric")
        params.put("exclude", "minutely")

        val dataFromInet = api.getWeather(params)
        if(dataFromInet.isSuccessful && dataFromInet.body()!=null){
            return dataFromInet.body()
        } else return null
    }
}

//        val resp = safetyCall{ api.getWeather(params)}
//
//        return when (resp){
//            is Result.Success -> resp.data
//            else -> null
//        }

//    private suspend fun <T> safetyCall(call: suspend () -> Response<T>): Result<T>{
//        val response: Result<T>
//        try {
//            val result = call.invoke()
//            response = if(result.isSuccessful){
//                Result.Success(result.body()!!)
//            } else{
//                Result.Error(result.code(), result.toString())
//            }
//            return response
//        } catch (e: Exception){
//            return when (e){
//                is SocketTimeoutException -> Result.ErrorTimeOut
//                is UnknownHostException -> Result.ErrorUnknown
//                else -> Result.ErrorUnknown
//            }
//        }
//    }
//}