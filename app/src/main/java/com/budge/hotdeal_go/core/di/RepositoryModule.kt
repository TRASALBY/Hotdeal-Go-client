package com.budge.hotdeal_go.core.di

import com.budge.hotdeal_go.data.repository.HotDealRepositoryImpl
import com.budge.hotdeal_go.data.repository.NoticeRepositoryImpl
import com.budge.hotdeal_go.domain.repository.HotDealRepository
import com.budge.hotdeal_go.domain.repository.NoticeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindHotDealRepository(hotDealRepositoryImpl: HotDealRepositoryImpl): HotDealRepository

    @Binds
    abstract fun bindNoticeRepository(noticeRepositoryImpl: NoticeRepositoryImpl): NoticeRepository
}
