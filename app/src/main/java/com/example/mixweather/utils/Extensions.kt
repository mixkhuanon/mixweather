package com.example.mixweather.utils

import android.text.format.DateFormat
import java.util.Calendar
import java.util.Locale

object Extensions {

    fun Double.toFahrenheit(): Double = ((this * 9 / 5) + 32)
    fun Double.toCelsius(): Double = ((this - 32) * 5 / 9)

    fun dateTimeFormatter(timestamp: Long): String {
        val calendar = Calendar.getInstance(Locale.ENGLISH)
        calendar.timeInMillis = timestamp * 1000L
        return DateFormat.format("dd-MM-yyyy", calendar).toString()
    }
}