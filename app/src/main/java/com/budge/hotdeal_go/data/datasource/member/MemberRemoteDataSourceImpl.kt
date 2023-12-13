package com.budge.hotdeal_go.data.datasource.member

import com.budge.hotdeal_go.data.api.MemberApi
import javax.inject.Inject

class MemberRemoteDataSourceImpl @Inject constructor(
    private val memberApi: MemberApi
) : MemberRemoteDataSource {
    override suspend fun loginWithKakao(socialToken: String) = memberApi.loginWithKakao(socialToken)
}