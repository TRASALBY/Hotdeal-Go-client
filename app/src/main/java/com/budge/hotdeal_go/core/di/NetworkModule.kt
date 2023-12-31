package com.budge.hotdeal_go.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class HotDealClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthClient

    @HotDealClient
    @Singleton
    @Provides
    fun provideOkHTTPClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.apply {
            addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    @AuthClient
    @Singleton
    @Provides
    fun provideAuthClient(
        authorizationInterceptor: Interceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.apply {
            addInterceptor(loggingInterceptor)
            addInterceptor(authorizationInterceptor)
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun providesAuthorizationInterceptor() = Interceptor { chain ->
        val request = chain.request().newBuilder()
        val hasAuthorization = chain.request().headers.names().contains("Authorization")

        if (hasAuthorization) {
            val accessToken = chain.request().header("Authorization")
            request.header("Authorization", "Bearer $accessToken")
        }
        chain.proceed(request.build())
    }

}
