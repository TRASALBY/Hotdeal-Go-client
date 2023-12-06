package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.View
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentAnnouncementBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment

class AnnouncementFragment : BaseFragment<FragmentAnnouncementBinding>(
    FragmentAnnouncementBinding::inflate,
    R.layout.fragment_announcement
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
