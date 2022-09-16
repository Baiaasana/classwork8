package com.example.classwork8.di

import android.content.Context
import com.example.classwork8.common.ResponseHandler
import com.example.classwork8.data.ApiService
import com.example.classwork8.data.remote.Interceptors
import com.example.classwork8.utility.Const
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        @ApplicationContext context: Context,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptors.oflineInterseptor(context = context))
            .addNetworkInterceptor(Interceptors.onlineInterceptor())
            .cache(Interceptors.cacheSize(context))
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun apiService(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun requestHandle(): ResponseHandler {
        return ResponseHandler()
    }
}