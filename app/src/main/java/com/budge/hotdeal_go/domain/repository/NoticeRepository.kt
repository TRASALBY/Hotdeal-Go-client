package com.budge.hotdeal_go.domain.repository

import com.budge.hotdeal_go.data.model.NoticeResponse

interface NoticeRepository {
    suspend fun getNoticeList(
        keyword: String?,
        pageNumber: Int,
        noticeCount: Int
    ): NoticeResponse
}
