package com.example.easybus.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.easybus.R
import com.example.easybus.databinding.ProfileFragmentBinding

class BaseProfileFragment : Fragment() {

    private lateinit var binding: ProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.profile_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.next.setOnClickListener {
            if (validateInputFields()) {
                findNavController().navigate(R.id.profile_to_payment)
            }
        }

        binding.close.setOnClickListener {
            findNavController().navigate(R.id.profile_to_onboarding)
        }

    }

    private fun validateInputFields(): Boolean {
        //TODO validate fields
        return true
    }
}