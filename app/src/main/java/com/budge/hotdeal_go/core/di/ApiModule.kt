package com.budge.hotdeal_go.core.di

import com.budge.hotdeal_go.data.api.HotDealApi
import com.budge.hotdeal_go.data.api.MemberApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class HotDealRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthRetrofit

    @HotDealRetrofit
    @Singleton
    @Provides
    fun provideHotDealRetrofit(
        @NetworkModule.HotDealClient
        okHttpClient: OkHttpClient
    ): Retrofit {
        val builder = Retrofit.Builder()
        builder
            .baseUrl("http://13.125.124.61:80/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

        return builder.build()
    }

    @AuthRetrofit
    @Singleton
    @Provides
    fun provideAuthRetrofit(
        @NetworkModule.AuthClient
        okHttpClient: OkHttpClient
    ): Retrofit {
        val builder = Retrofit.Builder()
        builder
            .baseUrl("http://13.125.124.61:80/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideHotDealAPI(
        @HotDealRetrofit
        retrofit: Retrofit
    ): HotDealApi = retrofit.create(HotDealApi::class.java)

    @Singleton
    @Provides
    fun provideMemberAPI(
        @AuthRetrofit
        retrofit: Retrofit
    ): MemberApi = retrofit.create(MemberApi::class.java)
}
