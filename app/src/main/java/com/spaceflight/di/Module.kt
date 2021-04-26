package com.spaceflight.di

import com.spaceflight.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

val viewModelModule = module {

}

val repositoryModule = module {

}

private fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

private fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {
     val retrofit = Retrofit
}