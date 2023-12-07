package com.budge.hotdeal_go.data.datasource.hotdeal

import com.budge.hotdeal_go.data.model.HotDealItem

interface HotDealRemoteDatasource {
    fun getHotdealFromFmkorea(): List<HotDealItem>
    fun getHotdealFromQuasarzone(): List<HotDealItem>
    fun getHotdealFromRuliweb(): List<HotDealItem>

}
