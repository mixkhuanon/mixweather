package com.example.mixweather.data.repository

import com.example.mixweather.data.model.DirectWeatherResponseModel
import com.example.mixweather.data.model.ForecastWeatherResponseModel
import com.example.mixweather.data.model.LocationResponseModel
import retrofit2.Response

interface WeatherDataSource {
    suspend fun getLocation(city: String): Response<List<LocationResponseModel>>
    suspend fun getDirectWeather(lat: Double, lon: Double): Response<DirectWeatherResponseModel>
    suspend fun getForecastWeather(lat: Double, lon: Double): Response<ForecastWeatherResponseModel>
}