package com.example.mixweather.data.model

import com.example.mixweather.data.model.forecastweather.City
import com.example.mixweather.data.model.forecastweather.ForecastWeatherList
import com.google.gson.annotations.SerializedName

data class ForecastWeatherResponseModel(
    @SerializedName("city") val city: City?,
    @SerializedName("cod") val cod: String?,
    @SerializedName("message") val message: Double?,
    @SerializedName("cnt") val cnt: Int?,
    @SerializedName("list") val list: List<ForecastWeatherList>,
)