package com.example.ticket.service

import com.example.ticket.model.HardwareData
import com.example.ticket.model.TicketModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface TicketService {

    @POST("ca30b574-72b5-40ed-b83c-63e547378ebe")
    fun getTicket(@Body data: HardwareData): Call<TicketModel>

    companion object {
        var retrofitService: TicketService? = null

        private val client =  OkHttpClient.Builder().build()

        fun getInstance() : TicketService {
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .client(client)
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(TicketService::class.java)
            }
            return retrofitService!!
        }
    }
}