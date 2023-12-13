package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.View
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentHomeBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.testTx.text = "This is home."
    }

}
