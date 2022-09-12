package com.example.moviesbluelabs.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesbluelabs.databinding.ActivityMovieBinding
import com.example.moviesbluelabs.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityMovie : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun navigateTo(){
        val intent = Intent(this, FragmentMovieDetailBinding::class.java)
        startActivity(intent)
    }


}