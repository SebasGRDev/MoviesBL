package com.example.moviesbluelabs.data.model.network

import com.example.moviesbluelabs.data.model.database.entities.MovieEntity
import com.example.moviesbluelabs.data.model.database.entities.dao.MovieDao
import com.example.moviesbluelabs.data.model.topratedmovies.MovieResult
import com.example.moviesbluelabs.domain.MovieDomain
import com.example.moviesbluelabs.domain.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: MovieResult,
    private val movieDao: MovieDao
) {

    suspend fun getAllMoviesFromApi(): List<MovieDomain> {
        val response = api.results
        return response.map { it.toDomain() }
    }

    suspend fun getAllMoviesFromDatabase(): List<MovieDomain> {
        val response: List<MovieEntity> = movieDao.getAllMovies()
        return response.map { it.toDomain() }
    }

    suspend fun clearMovies(){
        movieDao.deleteAllMovies()
    }
}