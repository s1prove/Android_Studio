package com.example.androidapp.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.Animal1
import com.example.androidapp.domain.weather.WeatherUseCase
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {


    private val weatherUseCase = WeatherUseCase

    val animalListLd = MutableLiveData<List<Animal1>>()
    val weatherLd = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()


//    init {
//        getWeather("50", "44")
//    }

    fun getWeather(lat: String, lon: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

//            val animalList = animalUseCase.getAnimal()
//            animalListLd.postValue(animalList)

            val data = weatherUseCase.getWeather(lat, lon)
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }
}