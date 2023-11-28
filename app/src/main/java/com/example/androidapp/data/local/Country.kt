package com.example.androidapp.data.local

import com.example.androidapp.R

class Country (val name: String, val country: String, val description: String, val image: Int, val lat: String, val lon: String){
    companion object {
        fun createCountryList(): List<Country> {
            return listOf(
                Country("Kyiv", "Ukraine", "Kyiv", R.drawable.kyiv, "50.27", "30.31"),
                Country("Tirane", "Albania", "Tirane", R.drawable.tirane, "40", "20"),
                Country("Tripoli", "Libya", "Tripoli", R.drawable.tripoli, "25", "15"),
                Country("Madrid", "Spain", "Madrid", R.drawable.madrid, "40", "5"),
                Country("Tunis", "Tunis", "Tunis", R.drawable.tunis, "35", "10")
            )
        }
    }
}