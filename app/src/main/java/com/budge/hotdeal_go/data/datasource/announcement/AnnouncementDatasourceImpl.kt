package com.budge.hotdeal_go.data.datasource.announcement

import com.budge.hotdeal_go.data.api.AnnouncementApi
import com.budge.hotdeal_go.data.model.FcmRequestBody
import com.budge.hotdeal_go.data.model.KeywordAddRequestToken
import javax.inject.Inject

class AnnouncementDatasourceImpl @Inject constructor(
    private val announcementApi: AnnouncementApi
) : AnnouncementDatasource {
    override suspend fun addFcmToken(userId: String, fcmToken: String) =
        announcementApi.addFcmToken(
            FcmRequestBody(userId, fcmToken)
        )

    override suspend fun addKeyword(userId: String, keywordName: String) =
        announcementApi.addKeyword(
            KeywordAddRequestToken(userId, keywordName)
        )
}