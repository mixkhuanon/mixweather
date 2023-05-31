package com.example.mixweather.di

import com.example.mixweather.data.repository.WeatherRepository
import com.example.mixweather.domain.GetDirectWeatherUseCase
import com.example.mixweather.domain.GetLocationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetLocationUseCase(
        weatherRepository: WeatherRepository
    ): GetLocationUseCase {
        return GetLocationUseCase(weatherRepository)
    }

    @Provides
    fun provideGetDirectWeatherUseCase(
        weatherRepository: WeatherRepository
    ): GetDirectWeatherUseCase {
        return GetDirectWeatherUseCase(weatherRepository)
    }
}