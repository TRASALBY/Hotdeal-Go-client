package com.budge.hotdeal_go.data.model

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val message: String
)