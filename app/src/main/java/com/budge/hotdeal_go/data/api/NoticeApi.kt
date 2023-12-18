package com.budge.hotdeal_go.data.api

import com.budge.hotdeal_go.data.model.NoticeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticeApi {
    @GET("/notice")
    fun getNoticeList(
        @Query("keyword")
        Keyword: String?,
        @Query("pgno")
        pageNumber: String?,
        @Query("npp")
        nowPageNumber: String?,
    ): NoticeResponse
}