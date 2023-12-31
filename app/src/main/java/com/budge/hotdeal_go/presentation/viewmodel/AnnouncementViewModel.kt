package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AnnouncementViewModel : ViewModel() {
    val keyword = MutableLiveData("")




    fun addFcmToken(){
        //TODO 토큰 등록
    }

    fun addkeyword(){
        //TODO 키워드 등록
    }
}