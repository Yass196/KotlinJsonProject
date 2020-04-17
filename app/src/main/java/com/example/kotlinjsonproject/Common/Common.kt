package com.example.kotlinjsonproject.Common

import com.example.kotlinjsonproject.Interface.RetrofitService
import com.example.kotlinjsonproject.Retrofit.RetrofitClient

object Common {
    private val URL = "https://www.simplifiecoding;net/demo/"
    val RETROSERVICE : RetrofitService
    get() = RetrofitClient.getClient(URL).create(RETROSERVICE::class.java)
}