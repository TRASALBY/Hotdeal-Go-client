package com.budge.hotdeal_go.data.datasource.notice

import com.budge.hotdeal_go.data.model.NoticeResponse

interface NoticeRemoteDatasource {
    suspend fun getNoticeList(
        keyword: String?,
        pageNumber: Int,
        noticeCount: Int
    ): NoticeResponse

}
