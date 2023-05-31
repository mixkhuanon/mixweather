package com.example.mixweather.data.model.directweather

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("id") val id: Int?,
    @SerializedName("main") val main: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("description") val icon: String?
)
