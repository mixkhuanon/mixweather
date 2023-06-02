package com.example.mixweather.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object Extensions {

    fun Double.toFahrenheit(): Double = ((this * 9 / 5) + 32)
    fun Double.toCelsius(): Double = ((this - 32) * 5 / 9)

    @SuppressLint("SimpleDateFormat")
    fun convertToDateTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy/MM/dd \nHH:mm")
        return format.format(date)
    }
}