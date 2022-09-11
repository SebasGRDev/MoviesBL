package com.example.moviesbluelabs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesbluelabs.databinding.ItemMoviesListBinding
import com.example.moviesbluelabs.model.moviesintheaters.MovieTheater

class MoviesTheatersAdapter(
    var listMoviesTheater : List<MovieTheater>)
    : RecyclerView.Adapter<MoviesTheatersAdapter.MoviesTheaterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesTheaterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesTheaterViewHolder(layoutInflater.inflate(R.layout.item_movies_list, parent, false))
    }

    override fun onBindViewHolder(
        holder: MoviesTheatersAdapter.MoviesTheaterViewHolder,
        position: Int
    ) {
        val movie = listMoviesTheater[position]
        holder.render(movie)
    }

    override fun getItemCount(): Int = listMoviesTheater.size

    class MoviesTheaterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMoviesListBinding.bind(view)

        fun render(moviesTheater : MovieTheater) {
            binding.tvTitle.text = moviesTheater.title
            binding.tvVoteAverage.text = moviesTheater.vote_average.toString()
            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500/${moviesTheater.poster_path}")
                .into(binding.ivPosterPath)
        }

    }

}