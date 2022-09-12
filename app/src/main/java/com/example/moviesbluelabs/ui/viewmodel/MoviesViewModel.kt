package com.example.moviesbluelabs.ui.viewmodel

import androidx.lifecycle.*
import com.example.moviesbluelabs.R
import com.example.moviesbluelabs.data.model.network.MovieClient
import com.example.moviesbluelabs.ui.view.adapter.TopMoviesAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(): ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    fun getMoviesTop(){
        val topMoviesAdapter = TopMoviesAdapter(emptyList())
        CoroutineScope(Dispatchers.IO).launch {
            isLoading.postValue(true)
            val apiKey = R.string.apy_key.toString()
            val topMovies = MovieClient.service.listTopMovies(apiKey)
            val body = topMovies.execute().body()

            CoroutineScope(Dispatchers.Main).launch {
                if (body != null) {
                    topMoviesAdapter.topMoviesList = body.results
                    isLoading.postValue(false)
                }
            }
        }
    }

}