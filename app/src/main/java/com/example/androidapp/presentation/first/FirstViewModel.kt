package com.example.androidapp.presentation.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.data.local.Country
import com.example.androidapp.data.remote.model.WeatherApiModel
import com.example.androidapp.domain.weather.WeatherUseCase
import kotlinx.coroutines.launch

class FirstViewModel: ViewModel() {

    private val weatherUseCase = WeatherUseCase

    val countryLd = MutableLiveData<List<Country>?>()
    val isLoading = MutableLiveData<Boolean>()


    fun getCountry() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val data = weatherUseCase.getCountry()
            countryLd.postValue(data)

            isLoading.postValue(false)
        }
    }
}