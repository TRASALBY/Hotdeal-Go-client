package com.budge.hotdeal_go.data.api

import com.budge.hotdeal_go.data.model.TokenResponse
import retrofit2.Response
import retrofit2.http.GET

interface MemberApi {

    @GET("/member/oauth/kakao")
    suspend fun loginWithKakao(): Response<TokenResponse>
}