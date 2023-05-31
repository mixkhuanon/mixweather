package com.example.mixweather.domain

import com.example.mixweather.data.model.LocationResponseModel
import com.example.mixweather.data.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend fun execute(city: String): Response<List<LocationResponseModel>> {
        return weatherRepository.getLocation(city)
    }
}