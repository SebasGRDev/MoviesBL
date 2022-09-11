package com.example.moviesbluelabs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesbluelabs.MoviesTheatersAdapter
import com.example.moviesbluelabs.R
import com.example.moviesbluelabs.TopMoviesAdapter
import com.example.moviesbluelabs.databinding.FragmentMoviesBinding
import com.example.moviesbluelabs.model.MovieClient
import com.example.moviesbluelabs.viewmodel.MoviesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Inflate RecyclerView Top Movies
        recyclerView = binding.rvTopMovies
        recyclerView.setHasFixedSize(true)
        binding.rvTopMovies.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        val topMoviesAdapter = TopMoviesAdapter(emptyList())
        binding.rvTopMovies.adapter = topMoviesAdapter

        CoroutineScope(Dispatchers.IO).launch {
            val apiKey = getString(R.string.apy_key)
            val topMovies = MovieClient.service.listTopMovies(apiKey)
            val body = topMovies.execute().body()

            CoroutineScope(Dispatchers.Main).launch {
                if (body != null) {
                    topMoviesAdapter.topMoviesList = body.results
                    topMoviesAdapter.notifyDataSetChanged()
                }
            }
        }

        //Inflate RecyclerView Movies in Theaters
        recyclerView = binding.rvMoviesTheaters
        recyclerView.setHasFixedSize(true)
        binding.rvMoviesTheaters.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        val moviesInTheaterAdapter = MoviesTheatersAdapter(emptyList())
        binding.rvMoviesTheaters.adapter = moviesInTheaterAdapter

        CoroutineScope(Dispatchers.IO).launch {
            val apiKey = getString(R.string.apy_key)
            val moviesTheater = MovieClient.service.listMoviesInTheaters(apiKey)
            val bodyTheater = moviesTheater.execute().body()

            CoroutineScope(Dispatchers.Main).launch {
                if (bodyTheater != null) {
                    moviesInTheaterAdapter.listMoviesTheater = bodyTheater.moviesinTheater
                    moviesInTheaterAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}