package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentHotDealBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment
import com.budge.hotdeal_go.presentation.viewmodel.HotDealViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "HotDealFragment"

@AndroidEntryPoint
class HotDealFragment : BaseFragment<FragmentHotDealBinding>(
    FragmentHotDealBinding::inflate,
    R.layout.fragment_hot_deal
) {

    private val viewModel by viewModels<HotDealViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserve()

        viewModel.searchItem(booleanArrayOf(false, true, true))
    }

    private fun setObserve() {
        viewModel.hotDealItemList.observe(viewLifecycleOwner) {
            Log.d(TAG, "onViewCreated: $it")
        }
    }


}
