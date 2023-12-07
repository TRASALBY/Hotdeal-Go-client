package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budge.hotdeal_go.domain.usecase.GetFmkoreaHotdelItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotDealViewModel @Inject constructor(
    private val getFmkoreaHotdelItems: GetFmkoreaHotdelItems
) : ViewModel() {

    fun getFmKoreaHotdeal(){
        viewModelScope.launch {
            getFmkoreaHotdelItems.getItems()
        }
    }


}
