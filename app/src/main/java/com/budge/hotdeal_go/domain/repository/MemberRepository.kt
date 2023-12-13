package com.budge.hotdeal_go.domain.repository

import com.budge.hotdeal_go.data.model.TokenResponse

interface MemberRepository {
    suspend fun loginWithKakao(socialToken: String): TokenResponse
}
