package com.budge.hotdeal_go.domain.usecase

import com.budge.hotdeal_go.domain.repository.KakaoLogin
import javax.inject.Inject

class KakaoLoginUseCase @Inject constructor(
    private val kakaoLogin: KakaoLogin
) {
    suspend operator fun invoke() = kakaoLogin.login()
}