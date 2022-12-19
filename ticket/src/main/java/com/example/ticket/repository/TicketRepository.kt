package com.example.ticket.repository

import com.example.ticket.model.HardwareData
import com.example.ticket.service.TicketService

class TicketRepository(
    private val ticketService: TicketService
) {
    fun getTicket(hardwareData: HardwareData) = ticketService.getTicket(hardwareData)
}