package com.budge.hotdeal_go.domain.usecase.announcement

import com.budge.hotdeal_go.domain.repository.AnnouncementRepository
import javax.inject.Inject

class AddKeywordUseCase @Inject constructor(
    private val repository: AnnouncementRepository
) {
    suspend operator fun invoke(userId: String, keywordName: String) =
        repository.addFcmToken(userId, keywordName)
}