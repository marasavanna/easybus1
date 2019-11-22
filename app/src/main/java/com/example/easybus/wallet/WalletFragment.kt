package com.example.easybus.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.easybus.R
import com.example.easybus.databinding.WalletFragmentBinding


class WalletFragment : Fragment() {

    private lateinit var binding: WalletFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.wallet_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFragment(SubscriptionsFragment())

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.subscriptions_nav -> {
                    loadFragment(SubscriptionsFragment())
                    true
                }
                R.id.profile_nav -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.let {
            with(it){
                replace(R.id.layout, fragment)
                addToBackStack(null)
                commit()
            }
        }
    }

}