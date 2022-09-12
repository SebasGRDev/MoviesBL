package com.example.moviesbluelabs.data.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesbluelabs.domain.MovieDomain

@Entity(tableName = "movie_table")
data class MovieEntity(

    @PrimaryKey(autoGenerate = true)
    val id_key : Int = 0,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "poster_path") val poster_path: String,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "vote_average") val vote_average: Double,
    @ColumnInfo(name = "vote_count") val vote_count: Int


)

fun MovieDomain.toDatabase() = MovieEntity(id, id, overview, popularity, poster_path, release_date, title, vote_average, vote_count)