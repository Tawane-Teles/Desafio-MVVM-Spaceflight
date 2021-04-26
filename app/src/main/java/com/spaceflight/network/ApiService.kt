package com.spaceflight.network

import com.spaceflight.network.response.NewResponse
import kotlinx.coroutines.Deferred
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v2/articles")
    fun getNews(
        @Query("_limit") limit: Int,
        @Query("_start") start: Int
    ) : Deferred<Response<List<NewResponse>>>
}