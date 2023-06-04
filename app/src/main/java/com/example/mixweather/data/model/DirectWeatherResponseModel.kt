package com.example.mixweather.data.model

import com.example.mixweather.data.model.directweather.Clouds
import com.example.mixweather.data.model.directweather.Coord
import com.example.mixweather.data.model.directweather.Main
import com.example.mixweather.data.model.directweather.Rain
import com.example.mixweather.data.model.directweather.Sys
import com.example.mixweather.data.model.directweather.Weather
import com.example.mixweather.data.model.directweather.Wind
import com.google.gson.annotations.SerializedName

data class DirectWeatherResponseModel(
    @SerializedName("coord") val coord: Coord?,
    @SerializedName("weather") val weather: List<Weather?>,
    @SerializedName("base") val base: String?,
    @SerializedName("main") val main: Main?,
    @SerializedName("visibility") val visibility: Int?,
    @SerializedName("wind") val wind: Wind?,
    @SerializedName("rain") val rain: Rain?,
    @SerializedName("clouds") val clouds: Clouds?,
    @SerializedName("dt") val dt: Long?,
    @SerializedName("sys") val sys: Sys?,
    @SerializedName("timezone") val timezone: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("cod") val cod: Int?,
)
