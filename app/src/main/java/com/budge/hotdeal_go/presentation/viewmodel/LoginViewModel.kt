package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budge.hotdeal_go.domain.usecase.KakaoLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase

): ViewModel() {

    fun kakaoLogin(){
        viewModelScope.launch {
            kakaoLoginUseCase()
        }
    }
}