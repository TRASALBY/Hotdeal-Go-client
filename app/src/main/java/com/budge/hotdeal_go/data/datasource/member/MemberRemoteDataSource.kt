package com.budge.hotdeal_go.data.datasource.member

import com.budge.hotdeal_go.data.model.Member
import com.budge.hotdeal_go.data.model.TokenResponse

interface MemberRemoteDataSource {
    suspend fun loginWithKakao(deviceId: String) : TokenResponse

    suspend fun getMemberInfo(): Member
}