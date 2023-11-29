package com.example.androidapp.data.local

import com.example.androidapp.R

class Country (val name: String, val country: String, val description: String, val image: Int, val lat: String, val lon: String){
    companion object {
        fun createCountryList(): List<Country> {
            return listOf(
                Country("Kharkiv", "Ukraine", "Kharkiv", R.drawable.kyiv, "49.98", "36.23"),
                Country("Tirana", "Albania", "Tirana", R.drawable.tirane, "41.32", "19.81"),
                Country("Rabak", "Libya", "Rabak", R.drawable.tripoli, "13.18", "32.88"),
                Country("Madrid", "Spain", "Madrid", R.drawable.madrid, "40.41", "-3.70"),
                Country("Sbikha", "Tunis", "Sbikha", R.drawable.tunis, "36", "10")
            )
        }
    }
}