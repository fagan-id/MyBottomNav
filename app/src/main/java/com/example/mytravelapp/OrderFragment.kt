package com.example.mytravelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mytravelapp.databinding.FragmentOrderBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class OrderFragment : Fragment() {

    private val binding by lazy{
        FragmentOrderBinding.inflate(layoutInflater)
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
            edtTicket.setOnClickListener{
                val action = OrderFragmentDirections.actionOrderFragmentToTicketTypeFragment()
                findNavController().navigate(action)
            }

            findNavController().currentBackStackEntry?.savedStateHandle?.let { handle ->
                handle.getLiveData<String>("type").observe(viewLifecycleOwner){
                        res -> edtTicket.setText(res)
                }
            }



            btnDone.setOnClickListener {
                // Get Current Date
                val currentDate = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(Date())

                // Format the message
                val message = "Tiket dengan tipe " + edtTicket.text.toString() + " berhasil dipesan pada $currentDate"

                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}