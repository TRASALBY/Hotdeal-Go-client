package com.budge.hotdeal_go.domain.usecase.login

import com.budge.hotdeal_go.domain.repository.MemberRepository
import javax.inject.Inject

class LoginWithKakaoUseCase @Inject constructor(
    private val repository: MemberRepository
) {
    suspend operator fun invoke(socialToken: String) = repository.loginWithKakao(socialToken)
}