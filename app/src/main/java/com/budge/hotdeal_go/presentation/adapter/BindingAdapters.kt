package com.budge.hotdeal_go.presentation.adapter

import android.util.Log
import androidx.databinding.BindingAdapter
import com.google.android.material.chip.ChipGroup

private const val TAG = "BindingAdapters_싸피"

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("bindTest")
    fun setChipGroup(view: ChipGroup, chipList: List<Int>) {
        view.checkedChipIds.clear()
        view.checkedChipIds.addAll(chipList)
        Log.d(TAG, "setChipGroup: ${chipList}")

    }
}
