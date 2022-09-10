package com.example.moviesbluelabs.model

data class MovieBLModel(
    val page: Int,
    val results: List<MovieDetail>,
    val total_pages: Int,
    val total_results: Int
)