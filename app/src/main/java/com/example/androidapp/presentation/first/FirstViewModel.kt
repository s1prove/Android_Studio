package com.example.androidapp.presentation.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.data.remote.model.WeatherApiModel
import com.example.androidapp.domain.weather.WeatherUseCase
import kotlinx.coroutines.launch

class FirstViewModel: ViewModel() {

    private val weatherUseCase = WeatherUseCase

    val weatherLd = MutableLiveData<WeatherApiModel?>()
    val isLoading = MutableLiveData<Boolean>()


    fun getWeather1(lat: String, lon: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            val data = weatherUseCase.getWeather(lat, lon)
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }
}