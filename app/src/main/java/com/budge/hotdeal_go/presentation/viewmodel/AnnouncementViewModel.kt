package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budge.hotdeal_go.data.model.NoticeItem
import com.budge.hotdeal_go.domain.usecase.GetNoticeByPageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnnouncementViewModel @Inject constructor(
    private val getNoticeByPageUseCase: GetNoticeByPageUseCase
) : ViewModel() {
    private val _noticeList: MutableLiveData<List<NoticeItem>> = MutableLiveData(emptyList())
    val noticeItem: LiveData<List<NoticeItem>> get() = _noticeList

    private val _pageNum = MutableLiveData(1)
    val pageNum: LiveData<Int> get() = _pageNum

    private val _totalPageCnt = MutableLiveData(1)
    val totalPageCnt: LiveData<Int> get() = _totalPageCnt

    val keyword = MutableLiveData("")

    fun getNoticeListByPage(noticeCnt: Int) {
        viewModelScope.launch {
            val result = getNoticeByPageUseCase(keyword.value, pageNum.value ?: 1, noticeCnt)
            _noticeList.value = result.noticeList
            if (result.totalPageCnt != totalPageCnt.value) {
                _totalPageCnt.value = result.totalPageCnt
            }
        }
    }

    fun changeNowPage(nowPage: Int) {
        _pageNum.value = nowPage
    }
}