package com.budge.hotdeal_go.data.datasource.announcement

interface AnnouncementDatasource {
    suspend fun addFcmToken(
        userId: String,
        fcmToken : String
    )

    suspend fun addKeyword(
        userId: String,
        keywordName: String
    )
}