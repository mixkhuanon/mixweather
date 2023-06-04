package com.example.mixweather.data.model.forecastweather

import com.example.mixweather.data.model.directweather.Clouds
import com.example.mixweather.data.model.directweather.Main
import com.example.mixweather.data.model.directweather.Rain
import com.example.mixweather.data.model.directweather.Weather
import com.google.gson.annotations.SerializedName

data class ForecastWeatherList(
    @SerializedName("dt") val dt: Long?,
    @SerializedName("main") val main: Main?,
    @SerializedName("sunrise") val sunrise: Int?,
    @SerializedName("sunset") val sunset: Int?,
    @SerializedName("temp") val temp: Temp?,
    @SerializedName("feels_like") val feelsLike: FeelLike?,
    @SerializedName("pressure") val pressure: Int?,
    @SerializedName("humidity") val humidity: Int?,
    @SerializedName("weather") val weather: List<Weather?>,
    @SerializedName("speed") val speed: Double?,
    @SerializedName("deg") val deg: Int?,
    @SerializedName("gust") val gust: Double?,
    @SerializedName("clouds") val clouds: Clouds?,
    @SerializedName("pop") val pop: Double?,
    @SerializedName("rain") val rain: Rain?,
    @SerializedName("dt_txt") val dtText: String?,
)
