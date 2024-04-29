package com.example.aapoondigitaltest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aapoondigitaltest.repository.ArticleRepository
import com.example.aapoondigitaltest.viewmodel.ArticleVM

class CustomViewModelFactory(private val repo: ArticleRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ArticleVM::class.java)){
            return ArticleVM(repo) as T
        }
        return super.create(modelClass)
    }
}