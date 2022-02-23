package com.lahsuak.apps.task1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

object RetroInstance {
    private val BASE_URL ="https://www.devops.tileswale.com"

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: DataApi by lazy{
        retrofit.create(DataApi::class.java)
    }
}