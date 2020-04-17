package com.example.kotlinjsonproject.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit : Retrofit ? = null
    fun getClient(Url : String): Retrofit{
    if(retrofit==null){
        retrofit = Retrofit.Builder().baseUrl(Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
        return retrofit !!

    }
}