package com.sobhan.sabaideatask.ui.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.room.Query
import com.mancj.materialsearchbar.MaterialSearchBar
import com.sobhan.sabaideatask.databinding.ActivityMainBinding
import com.sobhan.sabaideatask.ui.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MaterialSearchBar.OnSearchActionListener {
    private lateinit var binding: ActivityMainBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private val adapter = MovieAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setAdapter()
        binding.searchBar.setOnSearchActionListener(this)
        movieViewModel.movies.observe(this, Observer {
            adapter.setResults(it)
        })
    }



    private fun setAdapter(){
        binding.apply {
            rvMovies.adapter = adapter
        }
    }

    private fun searchMovie(query: String){
        movieViewModel.searchMovie(query)
    }

    override fun onSearchStateChanged(enabled: Boolean) {

    }

    override fun onSearchConfirmed(text: CharSequence?) {
        Log.d("sdfsf","dssa")

        searchMovie(text.toString())
    }

    override fun onButtonClicked(buttonCode: Int) {

    }
}