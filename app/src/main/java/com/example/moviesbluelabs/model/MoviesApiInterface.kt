package com.example.moviesbluelabs.model

import com.example.moviesbluelabs.model.moviesintheaters.MovieTheater
import com.example.moviesbluelabs.model.moviesintheaters.MoviesTheatersResult
import com.example.moviesbluelabs.model.topratedmovies.MovieResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiInterface {

    @GET("movie/top_rated")
    fun listTopMovies(@Query("api_key")apiKey: String): Call<MovieResult>

    @GET("movie/now_playing")
    fun listMoviesInTheaters(@Query("api_key")apiKey: String): Call<MoviesTheatersResult>
}