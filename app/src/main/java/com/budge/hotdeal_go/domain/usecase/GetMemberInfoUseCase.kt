package com.budge.hotdeal_go.domain.usecase

import com.budge.hotdeal_go.domain.repository.MemberRepository
import javax.inject.Inject

class GetMemberInfoUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke() = memberRepository.getMemberInfo()
}