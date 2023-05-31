package com.example.mixweather.data.repository

import com.example.mixweather.data.api.WeatherApi
import com.example.mixweather.data.model.DirectWeatherResponseModel
import com.example.mixweather.data.model.LocationResponseModel
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherDataSource {

    override suspend fun getLocation(city: String): Response<List<LocationResponseModel>> {
        return weatherApi.getLocation(city)
    }

    override suspend fun getDirectWeather(
        lat: Double,
        lon: Double
    ): Response<DirectWeatherResponseModel> {
        return weatherApi.getDirectWeather(lat, lon)
    }
}