package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.View
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentHotDealBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment


class HotDealFragment : BaseFragment<FragmentHotDealBinding>(
    FragmentHotDealBinding::inflate,
    R.layout.fragment_hot_deal
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
