package com.budge.hotdeal_go.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budge.hotdeal_go.domain.usecase.login.LoginWithKakaoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LoginViewModel_트라"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithKakaoUseCase: LoginWithKakaoUseCase
) : ViewModel() {

    fun loginWithKakao(kakaoToken: String) {
        viewModelScope.launch {

            Log.d(TAG, "loginWithKakao: ${loginWithKakaoUseCase(kakaoToken)}")
        }
    }
}