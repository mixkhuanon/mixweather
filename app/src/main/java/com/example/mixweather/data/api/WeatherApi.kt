package com.example.mixweather.data.api

import com.example.mixweather.BuildConfig
import com.example.mixweather.data.model.DirectWeatherResponseModel
import com.example.mixweather.data.model.ForecastWeatherResponseModel
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
        @Query("limit") limit: Int = ONE_CONST,
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Response<List<LocationResponseModel>>

    @GET("data/2.5/weather?")
    suspend fun getDirectWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = UNITS_CONST,
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Response<DirectWeatherResponseModel>

    @GET("data/2.5/forecast?")
    suspend fun getForecastWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("cnt") cnt: Int = TEN_CONST,
        @Query("units") units: String = UNITS_CONST,
        @Query("appid") apiKey: String = BuildConfig.API_KEY
    ): Response<ForecastWeatherResponseModel>

    companion object {
        private const val ONE_CONST = 1
        private const val TEN_CONST = 10
        private const val UNITS_CONST = "metric"
    }

}