package com.example.aapoondigitaltest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aapoondigitaltest.CustomViewModelFactory
import com.example.aapoondigitaltest.Network.ApiService
import com.example.aapoondigitaltest.R
import com.example.aapoondigitaltest.repository.ArticleRepository
import com.example.aapoondigitaltest.viewmodel.ArticleVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var apiService:ApiService
    lateinit var vm:ArticleVM
    var adap:ArticleAdapter?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo=ArticleRepository(apiService)
        vm= ViewModelProvider(this,CustomViewModelFactory(repo))[ArticleVM::class.java]
        val recyclerview = findViewById<RecyclerView>(R.id.recyc)

        recyclerview.layoutManager = LinearLayoutManager(this)
        callApi()
        vm.loginLive.observe(this, Observer {
            if(adap==null){
                adap=ArticleAdapter()
                adap?.list=it!!
                recyclerview.adapter=adap
            }else{
                adap?.list=it!!
                adap?.notifyDataSetChanged()
            }
        })
    }

    private fun callApi(){
        CoroutineScope(Dispatchers.IO).launch {
            vm.articleApi()
        }
    }
}