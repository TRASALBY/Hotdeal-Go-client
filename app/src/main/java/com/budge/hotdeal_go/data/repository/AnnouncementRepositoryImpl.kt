package com.budge.hotdeal_go.data.repository

import com.budge.hotdeal_go.data.datasource.announcement.AnnouncementDatasource
import com.budge.hotdeal_go.domain.repository.AnnouncementRepository
import javax.inject.Inject

class AnnouncementRepositoryImpl @Inject constructor(
    private val datasource: AnnouncementDatasource
) : AnnouncementRepository {
    override suspend fun addFcmToken(userId: String, fcmToken: String) =
        datasource.addFcmToken(userId, fcmToken)

    override suspend fun addKeyword(userId: String, keywordName: String) =
        datasource.addKeyword(userId, keywordName)

}