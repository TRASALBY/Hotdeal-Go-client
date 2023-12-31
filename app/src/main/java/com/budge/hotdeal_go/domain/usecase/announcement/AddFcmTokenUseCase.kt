package com.budge.hotdeal_go.domain.usecase.announcement

import com.budge.hotdeal_go.domain.repository.AnnouncementRepository
import javax.inject.Inject

class AddFcmTokenUseCase @Inject constructor(
    private val repository: AnnouncementRepository
) {
    suspend operator fun invoke(userId: String, fcmToken: String) =
        repository.addFcmToken(userId, fcmToken)
}