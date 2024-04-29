package com.example.aapoondigitaltest.repository

import com.example.aapoondigitaltest.Model.ArticleModel
import com.example.aapoondigitaltest.Network.ApiService
import retrofit2.Response

class ArticleRepository(private val apiService: ApiService) {

    suspend fun callArticleService(): Response<ArticleModel> {
        return apiService.articleService()
    }
}