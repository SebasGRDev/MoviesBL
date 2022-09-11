package com.example.moviesbluelabs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesbluelabs.databinding.ItemMoviesListBinding
import com.example.moviesbluelabs.model.Movie
import com.example.moviesbluelabs.model.MovieResult

class TopMoviesAdapter(
    var topMoviesList: List<Movie>)
    : RecyclerView.Adapter<TopMoviesAdapter.TopMoviesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TopMoviesViewHolder(layoutInflater.inflate(R.layout.item_movies_list, parent, false))
    }

    override fun onBindViewHolder(holder: TopMoviesViewHolder, position: Int) {
        val movie = topMoviesList[position]
        holder.render(movie)
    }

    override fun getItemCount(): Int = topMoviesList.size


    class TopMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemMoviesListBinding.bind(view)

        fun render(movieTop : Movie) {
            binding.tvTitle.text = movieTop.title
            binding.tvVoteAverage.text = movieTop.vote_average.toString()
            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500/${movieTop.poster_path}")
                .into(binding.ivPosterPath)
        }
    }
}
