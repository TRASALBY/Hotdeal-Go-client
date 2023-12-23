package com.budge.hotdeal_go.data.api

import com.budge.hotdeal_go.core.constant.PrefsKey
import com.budge.hotdeal_go.core.util.EncryptedPrefs
import com.budge.hotdeal_go.data.model.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MemberApi {

    @GET("/member/oauth/kakao")
    suspend fun loginWithKakao(
        @Header("Authorization") token: String = EncryptedPrefs.getString(PrefsKey.SOCIAL_TOKEN_KEY),
        ): Response<TokenResponse>
}