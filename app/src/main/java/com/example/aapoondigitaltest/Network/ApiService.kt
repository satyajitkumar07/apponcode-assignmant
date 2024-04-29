package com.example.aapoondigitaltest.Network

import com.example.aapoondigitaltest.Model.ArticleModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(WebserviceConstant.articleRes)
    suspend fun articleService(): Response<ArticleModel>
}