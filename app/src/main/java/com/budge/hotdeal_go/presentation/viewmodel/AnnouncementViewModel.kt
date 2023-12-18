package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.budge.hotdeal_go.data.model.NoticeItem
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AnnouncementViewModel : ViewModel() {
    private val _noticeList: MutableLiveData<List<NoticeItem>> = MutableLiveData(emptyList())
    val noticeItem: LiveData<List<NoticeItem>> get() = _noticeList


}