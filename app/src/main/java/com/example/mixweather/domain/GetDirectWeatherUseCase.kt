package com.example.mixweather.domain

import com.example.mixweather.data.model.DirectWeatherResponseModel
import com.example.mixweather.data.repository.WeatherDataSource
import retrofit2.Response
import javax.inject.Inject

class GetDirectWeatherUseCase @Inject constructor(
    private val weatherDataSource: WeatherDataSource
) {
    suspend fun execute(lat: Double, lon: Double): Response<DirectWeatherResponseModel> {
        return weatherDataSource.getDirectWeather(lat, lon)
    }
}