package com.example.aapoondigitaltest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aapoondigitaltest.Model.ArticleModel
import com.example.aapoondigitaltest.repository.ArticleRepository

class ArticleVM (private val repo:ArticleRepository) : ViewModel() {
    private var articleLive_= MutableLiveData<ArticleModel?>()
    var loginLive=articleLive_

    suspend fun articleApi(){
        val res=repo.callArticleService()
        if(res.isSuccessful){
            val body=res.body()
            loginLive.postValue(body)
        }else{
//            loginLive.postValue(NetworkResult.Error(res.message(),res.body()))
        }
    }
}