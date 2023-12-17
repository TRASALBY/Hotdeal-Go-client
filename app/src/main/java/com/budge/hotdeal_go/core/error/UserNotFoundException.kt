package com.budge.hotdeal_go.core.error

class UserNotFoundException(message: String = "사용자 정보가 존재하지 않음") : Throwable(message)