package com.example.mixweather.forecastweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mixweather.R
import com.example.mixweather.data.model.forecastweather.ForecastWeatherList
import com.example.mixweather.databinding.ItemForecastWeatherListBinding

class ForecastWeatherListViewHolder constructor(
    private val binding: ItemForecastWeatherListBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val context = itemView.context

    fun bind(
        weatherList: ForecastWeatherList
    ) {
        val degree = weatherList.main?.temp.toString() + context.getString(R.string.degrees_celsius)
        binding.dateTime.text = weatherList.dtText
        binding.temp.text = degree
        binding.humidity.text = weatherList.main?.humidity.toString()
    }

    companion object {
        fun newInstance(parent: ViewGroup): ForecastWeatherListViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemForecastWeatherListBinding.inflate(inflater, parent, false)
            return ForecastWeatherListViewHolder(binding)
        }
    }
}