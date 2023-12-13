package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.budge.hotdeal_go.core.constant.PrefsKey
import com.budge.hotdeal_go.core.util.EncryptedPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {


    private val _loginState =
        MutableLiveData(EncryptedPrefs.getString(PrefsKey.ACCESS_TOKEN_KEY).isNotEmpty())
    val loginState: LiveData<Boolean> get() = _loginState


    fun setLoginState(loginResult: Boolean) {
        _loginState.value = loginResult
    }
}