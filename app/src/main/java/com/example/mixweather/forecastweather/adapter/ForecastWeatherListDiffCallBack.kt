package com.example.mixweather.forecastweather.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mixweather.data.model.forecastweather.ForecastWeatherList

class ForecastWeatherListDiffCallBack : DiffUtil.ItemCallback<ForecastWeatherList>() {

    override fun areItemsTheSame(
        oldItem: ForecastWeatherList,
        newItem: ForecastWeatherList
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: ForecastWeatherList,
        newItem: ForecastWeatherList
    ): Boolean {
        return oldItem == newItem
    }
}