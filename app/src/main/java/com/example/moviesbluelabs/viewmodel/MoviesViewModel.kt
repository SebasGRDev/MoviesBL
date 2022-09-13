package com.example.moviesbluelabs.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesbluelabs.MoviesTheatersAdapter
import com.example.moviesbluelabs.R
import com.example.moviesbluelabs.model.MovieClient
import com.example.moviesbluelabs.model.topratedmovies.Movie
import com.example.moviesbluelabs.view.MoviesFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>(emptyList())
    val movies: LiveData<List<Movie>> get() = _movies

}