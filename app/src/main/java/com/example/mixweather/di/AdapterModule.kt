package com.example.mixweather.di

import com.example.mixweather.forecastweather.adapter.ForecastWeatherListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideForecastWeatherListAdapter(): ForecastWeatherListAdapter {
        return ForecastWeatherListAdapter()
    }
}