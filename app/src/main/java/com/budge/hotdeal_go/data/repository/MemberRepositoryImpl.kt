package com.budge.hotdeal_go.data.repository

import com.budge.hotdeal_go.core.constant.PrefsKey
import com.budge.hotdeal_go.core.util.EncryptedPrefs
import com.budge.hotdeal_go.data.datasource.member.MemberRemoteDataSource
import com.budge.hotdeal_go.data.model.TokenResponse
import com.budge.hotdeal_go.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val dataSource: MemberRemoteDataSource
) : MemberRepository {
    override suspend fun loginWithKakao(deviceId: String): Boolean {
        val result = runCatching { dataSource.loginWithKakao(deviceId) }.getOrNull()

        if (result != null) {
            saveTokens(result)
        }
        return result != null
    }

    private fun saveTokens(token: TokenResponse) {
        EncryptedPrefs.putString(PrefsKey.ACCESS_TOKEN_KEY, token.accessToken)
        EncryptedPrefs.putString(PrefsKey.REFRESH_TOKEN_KEY, token.refreshToken)
    }

}
