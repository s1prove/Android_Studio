package com.example.androidapp.data

import com.example.androidapp.data.local.Country
import com.example.androidapp.data.remote.model.WeatherApiModel

object CountryRepository {
    fun getCountry(): List<Country>?{
        return Country.createCountryList()
    }
}