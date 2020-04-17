package com.example.kotlinjsonproject.Interface

import com.example.kotlinjsonproject.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET(value = "marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}