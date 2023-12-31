package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budge.hotdeal_go.domain.usecase.announcement.AddFcmTokenUseCase
import com.budge.hotdeal_go.domain.usecase.announcement.AddKeywordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnnouncementViewModel @Inject constructor(
    private val addFcmTokenUseCase: AddFcmTokenUseCase,
    private val addKeywordUseCase: AddKeywordUseCase
) : ViewModel() {
    val keyword = MutableLiveData("")

    fun addFcmToken() {
        viewModelScope.launch {
            addFcmTokenUseCase("", "")
        }
    }

    fun addKeyword() {
        viewModelScope.launch {
            addKeywordUseCase("", keyword.value ?: "")
        }
    }
}