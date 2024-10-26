package com.example.mytravelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mytravelapp.databinding.FragmentTicketBinding


class TicketFragment : Fragment() {

    private val binding by lazy{
        FragmentTicketBinding.inflate(layoutInflater)
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
            btnBuy.setOnClickListener{
                val action = TicketFragmentDirections.actionTicketFragmentToOrderFragment()
                findNavController().navigate(action)
            }
        }
    }
}