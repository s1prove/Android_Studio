package com.example.androidapp.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.Animal1
import com.example.androidapp.data.remote.model.WeatherApiModel
import com.example.androidapp.domain.weather.WeatherUseCase
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {


    private val weatherUseCase = WeatherUseCase

    val weatherLd = MutableLiveData<WeatherApiModel?>()
    val isLoading = MutableLiveData<Boolean>()


    fun getWeather(lat: String, lon: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val data = weatherUseCase.getWeather(lat, lon)
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }
}