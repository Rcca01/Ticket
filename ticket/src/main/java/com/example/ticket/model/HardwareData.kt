package com.example.ticket.model

import com.google.gson.annotations.SerializedName

data class HardwareData(
    @SerializedName("systemUptime")
    val systemUptime: String,

    @SerializedName("latitude")
    val latitude: String,

    @SerializedName("longitude")
    val longitude: String,

    @SerializedName("altitude")
    val altitude: String,

    @SerializedName("deviceModel")
    val deviceModel: String
)
