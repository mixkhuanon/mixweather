package com.example.mixweather.data.api

import com.example.mixweather.BuildConfig
import com.example.mixweather.data.model.DirectWeatherResponseModel
import com.example.mixweather.data.model.LocationResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    @GET("geo/1.0/direct?")
    suspend fun getLocation(
        @Query("q") city: String,
        @Query("limit") limit: Int = 1,
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Response<List<LocationResponseModel>>

    @GET("data/2.5/weather?")
    suspend fun getDirectWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") unit: String = "metric",
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Response<DirectWeatherResponseModel>
}