package com.budge.hotdeal_go.data.api

import com.budge.hotdeal_go.data.model.FcmRequestBody
import com.budge.hotdeal_go.data.model.KeywordAddRequestToken
import retrofit2.http.Body
import retrofit2.http.POST

interface AnnouncementApi {
    @POST("/fcm/token")
    suspend fun addFcmToken(
        @Body fcmRequestBody: FcmRequestBody
    )

    @POST("/fcm/keyword")
    suspend fun addKeyword(
        @Body keywordAddRequestToken: KeywordAddRequestToken
    )
}