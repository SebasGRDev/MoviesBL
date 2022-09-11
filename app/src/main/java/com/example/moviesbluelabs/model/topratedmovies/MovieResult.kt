package com.example.moviesbluelabs.model.topratedmovies

data class MovieResult(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)