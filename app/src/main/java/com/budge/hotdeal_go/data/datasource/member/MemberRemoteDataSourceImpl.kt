package com.budge.hotdeal_go.data.datasource.member

import com.budge.hotdeal_go.core.error.BadRequest
import com.budge.hotdeal_go.core.error.BodyNullException
import com.budge.hotdeal_go.core.error.UserNotFoundException
import com.budge.hotdeal_go.data.api.MemberApi
import com.budge.hotdeal_go.data.model.TokenResponse
import javax.inject.Inject

class MemberRemoteDataSourceImpl @Inject constructor(
    private val memberApi: MemberApi
) : MemberRemoteDataSource {
    override suspend fun loginWithKakao() : TokenResponse{
        val result = memberApi.loginWithKakao()
        val body = result.body()
        if(result.isSuccessful){
            if(body != null){
                return body
            } else {
                throw BodyNullException()
            }
        }
        else {
            when(result.code()){
                404 -> throw UserNotFoundException()
                else -> throw BadRequest("알 수 없는 오류")
            }
        }
    }
}