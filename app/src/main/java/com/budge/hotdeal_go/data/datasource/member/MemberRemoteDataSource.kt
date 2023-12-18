package com.budge.hotdeal_go.data.datasource.member

import com.budge.hotdeal_go.data.model.TokenResponse

interface MemberRemoteDataSource {
    suspend fun loginWithKakao() : TokenResponse
}