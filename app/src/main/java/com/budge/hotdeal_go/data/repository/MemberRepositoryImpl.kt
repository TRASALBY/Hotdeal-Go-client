package com.budge.hotdeal_go.data.repository

import com.budge.hotdeal_go.data.datasource.member.MemberRemoteDataSource
import com.budge.hotdeal_go.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val dataSource: MemberRemoteDataSource
) : MemberRepository {
    override suspend fun loginWithKakao(socialToken: String) =
        dataSource.loginWithKakao(socialToken)
}
