package com.budge.hotdeal_go.data.model

data class Member(
    val admin: Int,
    val contactEmail: String,
    val id: String,
    val nickname: String,
    val no: Int,
    val password: String,
    val provider: String,
    val providerId: String,
    val registerTime: String
)