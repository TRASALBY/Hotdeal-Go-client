package com.budge.hotdeal_go.data.repository

import com.budge.hotdeal_go.data.datasource.hotdeal.HotDealRemoteDatasource
import com.budge.hotdeal_go.data.model.HotDealItem
import com.budge.hotdeal_go.domain.repository.HotDealRepository
import javax.inject.Inject

class HotDealRepositoryImpl @Inject constructor(
    private val datasource: HotDealRemoteDatasource
) : HotDealRepository {
    override fun getHotdealFromFmkorea(): List<HotDealItem> {
        return datasource.getHotdealFromFmkorea()
    }

    override fun getHotdealFromQuasarzone(): List<HotDealItem> {
        return datasource.getHotdealFromQuasarzone()
    }

    override fun getHotdealFromRuliweb(): List<HotDealItem> {
        return datasource.getHotdealFromRuliweb()
    }
}
