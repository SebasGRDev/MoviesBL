package com.example.moviesbluelabs.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/top_rated")
    fun topRatedMoviesList(@Query("api_key")apiKey: String): Call<MovieDetail>
}