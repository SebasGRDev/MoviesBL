package com.example.moviesbluelabs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesbluelabs.databinding.ItemMoviesListBinding
import com.example.moviesbluelabs.model.MovieBLModel
import com.example.moviesbluelabs.model.MovieDetail

class TopMoviesAdapter(private val topMoviesList : List<MovieDetail>) : RecyclerView.Adapter<TopMoviesAdapter.TopMoviesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TopMoviesViewHolder(layoutInflater.inflate(R.layout.item_movies_list, parent, false))
    }

    override fun onBindViewHolder(holder: TopMoviesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = topMoviesList.size


    class TopMoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemMoviesListBinding.bind(view)

        fun render(movieTop : MovieDetail) {
            binding.tvTitle.text = movieTop.title
            binding.tvQualification.text = movieTop.vote_count.toString()
            binding.tvVoteAverage.text = movieTop.vote_average.toString()
            Glide.with(binding.ivPosterPath.context).load(movieTop.poster_path).into(binding.ivPosterPath)
        }
    }
}
