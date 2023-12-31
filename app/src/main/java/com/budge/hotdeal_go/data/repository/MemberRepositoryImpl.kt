package com.budge.hotdeal_go.data.repository

import com.budge.hotdeal_go.core.constant.PrefsKey
import com.budge.hotdeal_go.core.error.UserNotFoundException
import com.budge.hotdeal_go.core.util.EncryptedPrefs
import com.budge.hotdeal_go.data.datasource.member.MemberRemoteDataSource
import com.budge.hotdeal_go.data.model.Member
import com.budge.hotdeal_go.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val dataSource: MemberRemoteDataSource
) : MemberRepository {
    override suspend fun loginWithKakao(deviceId: String): Boolean {
        val result = runCatching { dataSource.loginWithKakao(deviceId) }.getOrNull()

        if (result != null) {
            EncryptedPrefs.putString(PrefsKey.ACCESS_TOKEN_KEY, result.accessToken)
            EncryptedPrefs.putString(PrefsKey.REFRESH_TOKEN_KEY, result.refreshToken)
        }
        return result != null
    }

    override suspend fun getMemberInfo(): Member {
        val result = runCatching { dataSource.getMemberInfo() }.getOrNull()
        if (result != null) {
            EncryptedPrefs.putMember(PrefsKey.MEMBER_KEY, result)
            return result
        } else {
            throw UserNotFoundException()
        }
    }

}
