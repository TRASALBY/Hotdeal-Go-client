package com.budge.hotdeal_go.data.datasource.notice

import com.budge.hotdeal_go.data.api.NoticeApi
import javax.inject.Inject

class NoticeRemoteDatasourceImpl @Inject constructor(
    private val noticeApi: NoticeApi
) : NoticeRemoteDatasource {
    override suspend fun getNoticeList(
        keyword: String?,
        pageNumber: Int,
        noticeCount: Int
    ) = noticeApi.getNoticeList(keyword, pageNumber, noticeCount)

}
