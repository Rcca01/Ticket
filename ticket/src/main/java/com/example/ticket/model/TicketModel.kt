package com.example.ticket.model

import com.google.gson.annotations.SerializedName

data class TicketModel(
    @SerializedName("ticket")
    val ticket: String
)