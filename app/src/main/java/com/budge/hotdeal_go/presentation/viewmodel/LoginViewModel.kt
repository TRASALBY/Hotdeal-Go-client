package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budge.hotdeal_go.core.constant.PrefsKey
import com.budge.hotdeal_go.core.util.EncryptedPrefs
import com.budge.hotdeal_go.domain.usecase.announcement.AddFcmTokenUseCase
import com.budge.hotdeal_go.domain.usecase.login.LoginWithKakaoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithKakaoUseCase: LoginWithKakaoUseCase,
    private val addFcmTokenUseCase: AddFcmTokenUseCase
) : ViewModel() {

    private val _logInState = MutableLiveData(false)
    val logInState: LiveData<Boolean> get() = _logInState

    fun loginWithKakao() {
        viewModelScope.launch {
            _logInState.value = runCatching {
                loginWithKakaoUseCase()
            }.isSuccess
        }
    }

    fun addFcmToken() {
        viewModelScope.launch {
            addFcmTokenUseCase.invoke("", EncryptedPrefs.getString(PrefsKey.FCM_TOKEN_KEY))
        }
    }

}