package com.sobhan.sabaideatask.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sobhan.sabaideatask.databinding.ActivityMainBinding
import com.sobhan.sabaideatask.ui.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private val adapter = MovieAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setAdapter()
        movieViewModel.movies.observe(this, Observer {
            adapter.setResults(it)
        })
    }



    private fun setAdapter(){
        binding.apply {
            rvMovies.adapter = adapter
        }
    }
}