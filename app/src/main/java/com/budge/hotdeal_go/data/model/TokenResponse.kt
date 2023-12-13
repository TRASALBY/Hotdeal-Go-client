package com.budge.hotdeal_go.data.model

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("access-token")
    val accessToken: String,
    @SerializedName("refresh-token")
    val refreshToken: String
)