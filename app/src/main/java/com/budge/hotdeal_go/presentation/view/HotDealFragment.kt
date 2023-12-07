package com.budge.hotdeal_go.presentation.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentHotDealBinding
import com.budge.hotdeal_go.presentation.adapter.HotDealRecyclerViewAdapter
import com.budge.hotdeal_go.presentation.base.BaseFragment
import com.budge.hotdeal_go.presentation.decoration.VerticalItemDecorator
import com.budge.hotdeal_go.presentation.viewmodel.HotDealViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "HotDealFragment"

@AndroidEntryPoint
class HotDealFragment : BaseFragment<FragmentHotDealBinding>(
    FragmentHotDealBinding::inflate,
    R.layout.fragment_hot_deal
) {

    private val viewModel by viewModels<HotDealViewModel>()
    private lateinit var listAdapter: HotDealRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObserve()
        setRecyclerView()

        viewModel.searchItem(booleanArrayOf(false, true, true))

    }

    private fun setObserve() {
        viewModel.hotDealItemList.observe(viewLifecycleOwner) {
            Log.d(TAG, "onViewCreated: $it")
            listAdapter.submitList(it)
        }
    }

    private fun setRecyclerView() {
        binding.recyclerView.addItemDecoration(VerticalItemDecorator(20))
        listAdapter = HotDealRecyclerViewAdapter(
            itemClick = { hotDealItem ->
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(hotDealItem.url)))
            }
        )
        binding.recyclerView.adapter = listAdapter
    }


}
