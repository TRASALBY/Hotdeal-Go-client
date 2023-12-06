package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.View
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentNotificationBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment

class NotificationFragment : BaseFragment<FragmentNotificationBinding>(
    FragmentNotificationBinding::inflate,
    R.layout.fragment_notification
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
