package com.example.mixweather.data.model.directweather

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all") val all: Int?
)
