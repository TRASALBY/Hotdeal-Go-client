package com.budge.hotdeal_go.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.budge.hotdeal_go.domain.usecase.GetFmkoreaHotdealItems
import com.budge.hotdeal_go.domain.usecase.GetQuasarzoneHotdealItems
import com.budge.hotdeal_go.domain.usecase.GetRuliwebHotdealItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotDealViewModel @Inject constructor(
    private val getFmkoreaHotdelItems: GetFmkoreaHotdealItems,
    private val getQuasarzoneHotdealItems: GetQuasarzoneHotdealItems,
    private val getRuliwebHotdealItems: GetRuliwebHotdealItems
) : ViewModel() {

    fun getFmKoreaHotdeal(){
        viewModelScope.launch {
            getFmkoreaHotdelItems.getItems()
        }
    }

    fun getQuasarzoneHotdeal(){
        viewModelScope.launch {
            getQuasarzoneHotdealItems.getItems()
        }
    }

    fun getRuliwebHotdeal(){
        viewModelScope.launch {
            getRuliwebHotdealItems.getItems()
        }
    }


}
