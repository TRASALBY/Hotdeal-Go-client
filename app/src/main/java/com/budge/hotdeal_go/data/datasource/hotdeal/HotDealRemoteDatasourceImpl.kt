package com.budge.hotdeal_go.data.datasource.hotdeal

import com.budge.hotdeal_go.data.api.HotDealApi
import com.budge.hotdeal_go.data.model.HotDealItem
import javax.inject.Inject

class HotDealRemoteDatasourceImpl @Inject constructor(
    private val hotDealApi: HotDealApi
) : HotDealRemoteDatasource {
    override fun getHotdealFromFmkorea(): List<HotDealItem> {
        return hotDealApi.getHotdealFromFmkorea()
    }
}
