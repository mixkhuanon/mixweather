package com.example.mixweather.di

import com.example.mixweather.data.repository.WeatherDataSource
import com.example.mixweather.data.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(weatherRepository: WeatherRepository): WeatherDataSource
}