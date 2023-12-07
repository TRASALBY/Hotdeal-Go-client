package com.budge.hotdeal_go.core

import android.app.Application
import com.budge.hotdeal_go.BuildConfig
import com.budge.hotdeal_go.core.util.EncryptedPrefs
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HotDealApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
        EncryptedPrefs.initSharedPreferences(applicationContext)
    }
}
