package com.budge.hotdeal_go.data.api

import com.budge.hotdeal_go.data.model.HotDealItem
import retrofit2.http.GET


interface HotDealApi {

    @GET("/hotdeal/fmkorea")
    fun getHotdealFromFmkorea(

    ): List<HotDealItem>


    @GET("/hotdeal/quasarzone")
    fun getHotdealFromQuasarzone(

    ): List<HotDealItem>

    @GET("/hotdeal/ruliweb")
    fun getHotdealFromRuliweb(

    ): List<HotDealItem>



}
