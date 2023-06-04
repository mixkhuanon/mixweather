package com.example.mixweather.forecastweather.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.example.mixweather.data.model.forecastweather.ForecastWeatherList
import javax.inject.Inject

class ForecastWeatherListAdapter @Inject constructor() :
    ListAdapter<ForecastWeatherList, ForecastWeatherListViewHolder>(
        AsyncDifferConfig.Builder(
            ForecastWeatherListDiffCallBack()
        )
            .build()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForecastWeatherListViewHolder {
        return ForecastWeatherListViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: ForecastWeatherListViewHolder, position: Int) {
        holder.bind(weatherList = getItem(position))
    }
}