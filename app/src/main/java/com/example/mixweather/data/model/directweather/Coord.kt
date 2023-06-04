package com.example.mixweather.data.model.directweather

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat") var lat: Double = 0.0,
    @SerializedName("lon") var lon: Double = 0.0
)
