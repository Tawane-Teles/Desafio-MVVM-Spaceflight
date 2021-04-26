package com.spaceflight.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.spaceflight.network.ApiService
import com.spaceflight.utils.Constant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule = module {
    single { providerHttpLoggingInterceptor() }
    single { provideOkHttp(get()) }
    single { provideRetrofit(get()) }

}

val viewModelModule = module {

}

val repositoryModule = module {

}

private fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

private fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val okHttpClient = OkHttpClient.Builder()
    okHttpClient.apply {
        addInterceptor(httpLoggingInterceptor)
    }
    return okHttpClient.build()
}


private fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()

    return retrofit.create(ApiService::class.java)
}