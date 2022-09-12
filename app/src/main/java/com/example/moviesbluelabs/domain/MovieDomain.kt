package com.example.moviesbluelabs.domain

import com.example.moviesbluelabs.data.model.database.entities.MovieEntity
import com.example.moviesbluelabs.data.model.topratedmovies.Movie

data class MovieDomain(
    val id: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)

fun Movie.toDomain() = MovieDomain(id,  overview, popularity, poster_path, release_date, title,vote_average, vote_count)
fun MovieEntity.toDomain() = MovieDomain(id,  overview, popularity, poster_path, release_date, title,vote_average, vote_count)