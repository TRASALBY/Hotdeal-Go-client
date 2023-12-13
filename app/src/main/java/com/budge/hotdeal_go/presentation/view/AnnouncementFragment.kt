package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentAnnouncementBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment
import com.lakue.pagingbutton.OnPageSelectListener

class AnnouncementFragment : BaseFragment<FragmentAnnouncementBinding>(
    FragmentAnnouncementBinding::inflate,
    R.layout.fragment_announcement
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lpbButtonlist.setPageItemCount(4)
        binding.lpbButtonlist.addBottomPageButton(10,1)
        binding.lpbButtonlist.setOnPageSelectListener(object : OnPageSelectListener{
            override fun onPageBefore(nowPage: Int) {
                binding.lpbButtonlist.addBottomPageButton(10, nowPage)
                Toast.makeText(requireContext(), nowPage.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onPageCenter(nowPage: Int) {
                Toast.makeText(requireContext(), nowPage.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onPageNext(nowPage: Int) {
                binding.lpbButtonlist.addBottomPageButton(10, nowPage)
                Toast.makeText(requireContext(), nowPage.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }

}
