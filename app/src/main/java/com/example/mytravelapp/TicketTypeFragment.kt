package com.example.mytravelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.mytravelapp.databinding.FragmentTicketTypeBinding

class TicketTypeFragment : Fragment() {

    private val binding by lazy{
        FragmentTicketTypeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            val ticketType = resources.getStringArray(R.array.ticket_type)

            val adapterType = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, ticketType)
            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTicket.adapter = adapterType


            btnDone.setOnClickListener {
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.set("type", spinnerTicket.selectedItem.toString())
                }.navigateUp()
            }
        }



    }
}