package com.budge.hotdeal_go.data.repository

import com.budge.hotdeal_go.data.datasource.notice.NoticeRemoteDatasourceImpl
import com.budge.hotdeal_go.domain.repository.NoticeRepository
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val datasource: NoticeRemoteDatasourceImpl
) : NoticeRepository {
    override suspend fun getNoticeList(
        keyword: String?,
        pageNumber: Int,
        noticeCount: Int
    ) = datasource.getNoticeList(keyword, pageNumber, noticeCount)

}
