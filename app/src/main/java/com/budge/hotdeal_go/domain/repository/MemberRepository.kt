package com.budge.hotdeal_go.domain.repository

import com.budge.hotdeal_go.data.model.Member

interface MemberRepository {
    suspend fun loginWithKakao(deviceId: String): Boolean
    suspend fun getMemberInfo(): Member
}
