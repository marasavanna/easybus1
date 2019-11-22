package com.example.easybus.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.easybus.R
import com.example.easybus.databinding.ProfilePaymentFragmentBinding

class PaymentProfileFragment : Fragment() {

    private lateinit var binding: ProfilePaymentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater,
                R.layout.profile_payment_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.confirm.setOnClickListener {
            if (validateInputFields()) {
                findNavController().navigate(R.id.wallet_screen)
            }
        }
    }

    private fun validateInputFields(): Boolean {
        //TODO validate fields
        return true
    }
}