package com.budge.hotdeal_go.data.model

import com.google.gson.annotations.SerializedName

data class NoticeResponse(
    val noticeList: List<NoticeItem>,
    val currentPage: Int,
    @SerializedName("totalPageCount")
    val totalPageCnt: Int
)
