package com.example.moviesbluelabs.model.moviesintheaters

import com.google.gson.annotations.SerializedName

data class MoviesTheatersResult(
    val dates: Dates,
    val page: Int,
    @SerializedName("results")
    val moviesinTheater: List<MovieTheater>,
    val total_pages: Int,
    val total_results: Int
)