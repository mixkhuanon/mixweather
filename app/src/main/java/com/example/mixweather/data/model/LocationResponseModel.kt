package com.example.mixweather.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class LocationResponseModel(
    @SerializedName("name")
    val name: String?,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("country")
    val country: String?,
    @SerializedName("state")
    val state: String?
) : Serializable
