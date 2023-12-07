package com.budge.hotdeal_go.data.api

import com.budge.hotdeal_go.data.model.HotDealItem
import retrofit2.http.GET

interface HotDealApi {

    @GET("/hotdeal/fmkorea")
    fun getHotdealFromFmkorea(

    ): List<HotDealItem>

}
