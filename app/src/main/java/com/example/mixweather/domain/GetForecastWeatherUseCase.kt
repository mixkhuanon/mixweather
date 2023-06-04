package com.example.mixweather.domain

import com.example.mixweather.data.model.ForecastWeatherResponseModel
import com.example.mixweather.data.repository.WeatherDataSource
import retrofit2.Response
import javax.inject.Inject

class GetForecastWeatherUseCase @Inject constructor(
    private val weatherDataSource: WeatherDataSource
) {
    suspend fun execute(lat: Double, lon: Double): Response<ForecastWeatherResponseModel> {
        return weatherDataSource.getForecastWeather(lat, lon)
    }
}