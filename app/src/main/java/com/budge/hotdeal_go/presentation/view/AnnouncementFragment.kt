package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentAnnouncementBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment
import com.budge.hotdeal_go.presentation.viewmodel.AnnouncementViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnnouncementFragment : BaseFragment<FragmentAnnouncementBinding>(
    FragmentAnnouncementBinding::inflate,
    R.layout.fragment_announcement
) {

    private val viewModel by viewModels<AnnouncementViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBinding()
    }

    private fun setBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

}
