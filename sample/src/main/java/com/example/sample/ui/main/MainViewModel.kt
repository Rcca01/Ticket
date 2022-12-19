package com.example.sample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticket.Ticket
import com.example.ticket.model.HardwareData
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val ticketLibrary = Ticket.newInstance()

    private val _ticket = MutableLiveData<String>()
    val ticket: LiveData<String>
        get() = _ticket

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    fun getTicket() {
        viewModelScope.launch {
            ticketLibrary.getTicket(HardwareData(
                "", "", "", "", ""
            ),{ ticket ->
                _ticket.postValue(ticket)
            },{ isSuccess ->
                _error.postValue(isSuccess)
            })
        }
    }
}