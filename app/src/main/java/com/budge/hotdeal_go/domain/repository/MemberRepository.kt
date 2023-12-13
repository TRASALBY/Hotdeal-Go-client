package com.budge.hotdeal_go.domain.repository

interface MemberRepository {
    suspend fun loginWithKakao(socialToken: String): Boolean
}
