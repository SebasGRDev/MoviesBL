package com.example.moviesbluelabs.data.model.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesbluelabs.data.model.database.entities.dao.MovieDao

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao():MovieDao
}