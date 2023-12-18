package com.budge.hotdeal_go.data.api

import com.budge.hotdeal_go.data.model.NoticeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticeApi {
    @GET("/notice")
    suspend fun getNoticeList(
        @Query("keyword")
        Keyword: String?,
        @Query("pgno")
        pageNumber: Int?,
        @Query("npp")
        noticeCount: Int?,
    ): NoticeResponse
}