package com.example.ticket

import com.example.ticket.model.HardwareData
import com.example.ticket.model.TicketModel
import com.example.ticket.repository.TicketRepository
import com.example.ticket.service.TicketService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Ticket {
    private val retrofitTicket = TicketService.getInstance()
    private val ticketRepository = TicketRepository(retrofitTicket)

    fun getTicket(hardwareData: HardwareData, onTicket:(ticket:String?) -> Unit, error: (isSuccess:Boolean) -> Unit) {
        ticketRepository.getTicket(hardwareData).enqueue(object : Callback<TicketModel>{
            override fun onResponse(call: Call<TicketModel>, response: Response<TicketModel>) {
                onTicket(response.body()?.ticket ?: "")
            }

            override fun onFailure(call: Call<TicketModel>, t: Throwable) {
                error(false)
            }

        })
    }

    companion object {
        fun newInstance() = Ticket()
    }
}
