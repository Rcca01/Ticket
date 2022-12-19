package com.example.sample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.sample.R
import kotlinx.coroutines.channels.ticker

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var tvTicket: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        tvTicket = view.findViewById(R.id.message)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.ticket.observe(viewLifecycleOwner, Observer { ticket ->
            tvTicket.text = ticket
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            tvTicket.text = getString(R.string.text_error)
        })

        viewModel.getTicket()
    }
}