package com.example.mixweather.data.model.directweather

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h") val lh: Double?
)