package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentAnnouncementBinding
import com.budge.hotdeal_go.presentation.adapter.NoticeListAdapter
import com.budge.hotdeal_go.presentation.base.BaseFragment
import com.budge.hotdeal_go.presentation.viewmodel.AnnouncementViewModel
import com.lakue.pagingbutton.OnPageSelectListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnnouncementFragment : BaseFragment<FragmentAnnouncementBinding>(
    FragmentAnnouncementBinding::inflate,
    R.layout.fragment_announcement
) {

    private val viewModel: AnnouncementViewModel by viewModels()
    private lateinit var noticeAdapter: NoticeListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNoticeRecyclerView()
        setObserve()
        binding.lpbButtonlist.setPageItemCount(5)
    }


    private fun setNoticePageBtn(totalPageCnt: Int) {
        binding.lpbButtonlist.addBottomPageButton(totalPageCnt, viewModel.pageNum.value ?: 1)
        binding.lpbButtonlist.setOnPageSelectListener(object : OnPageSelectListener {
            override fun onPageBefore(nowPage: Int) {
                binding.lpbButtonlist.addBottomPageButton(totalPageCnt, nowPage)
                viewModel.changeNowPage(nowPage)
                Toast.makeText(requireContext(), nowPage.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onPageCenter(nowPage: Int) {
                viewModel.changeNowPage(nowPage)
                Toast.makeText(requireContext(), nowPage.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onPageNext(nowPage: Int) {
                binding.lpbButtonlist.addBottomPageButton(totalPageCnt, nowPage)
                viewModel.changeNowPage(nowPage)
                Toast.makeText(requireContext(), nowPage.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setNoticeRecyclerView() {
        noticeAdapter = NoticeListAdapter { noticeItem ->
        }

        binding.rvNoticeList.adapter = noticeAdapter
    }

    private fun setObserve() {
        viewModel.noticeItem.observe(viewLifecycleOwner) {
            noticeAdapter.submitList(it)
        }

        viewModel.totalPageCnt.observe(viewLifecycleOwner) {
            setNoticePageBtn(it)
        }

        viewModel.pageNum.observe(viewLifecycleOwner) {
            viewModel.getNoticeListByPage(NOTICE_COUNT)
        }
    }

    companion object {
        const val NOTICE_COUNT = 10
    }
}
