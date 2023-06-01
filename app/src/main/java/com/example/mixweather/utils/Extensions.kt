package com.example.mixweather.utils

object Extensions {

    fun Double.toFahrenheit(): Double = ((this * 9 / 5) + 32)

    fun Double.toCelsius(): Double = ((this - 32) * 5 / 9)
}