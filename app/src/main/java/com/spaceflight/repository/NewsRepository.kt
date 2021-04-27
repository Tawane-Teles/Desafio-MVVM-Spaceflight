package com.spaceflight.repository

import com.spaceflight.network.ApiService


class NewsRepository(private val apiService: ApiService) {
    suspend fun getNews(limit: Int, start: Int) = ApiService.getNews(limit, start)


}