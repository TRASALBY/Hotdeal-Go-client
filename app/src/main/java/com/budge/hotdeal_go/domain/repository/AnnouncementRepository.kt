package com.budge.hotdeal_go.domain.repository

interface AnnouncementRepository {
    suspend fun addFcmToken(
        userId: String,
        fcmToken : String
    )

    suspend fun addKeyword(
        userId: String,
        keywordName: String
    )
}