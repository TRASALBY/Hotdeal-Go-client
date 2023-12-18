package com.budge.hotdeal_go.domain.usecase

import com.budge.hotdeal_go.domain.repository.NoticeRepository
import javax.inject.Inject

class GetNoticeByPageUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(
        keyword: String?,
        pageNumber: Int,
        noticeCount: Int
    ) = noticeRepository.getNoticeList(keyword, pageNumber, noticeCount)
}