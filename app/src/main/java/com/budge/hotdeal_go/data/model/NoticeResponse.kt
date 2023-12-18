package com.budge.hotdeal_go.data.model

data class NoticeResponse(
    val noticeList: List<NoticeItem>,
    val currentPage: Int,
    val totalPageCount: Int
)
