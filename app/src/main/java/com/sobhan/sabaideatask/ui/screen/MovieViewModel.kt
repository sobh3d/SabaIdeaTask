package com.sobhan.sabaideatask.ui.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sobhan.sabaideatask.data.repositories.movie.MovieDataSingleSourceOfTruth
import com.sobhan.sabaideatask.data.utils.Result
import com.sobhan.sabaideatask.model.Datum
import com.sobhan.sabaideatask.ui.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private var movieDataSingleSourceOfTruth: MovieDataSingleSourceOfTruth
) : BaseViewModel() {

    private val _movies = MutableLiveData<List<Datum>>()
    val movies: LiveData<List<Datum>> = _movies
    private val moviesList: MutableList<Datum> = ArrayList()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {

        observe(
            movieDataSingleSourceOfTruth.getMovies(),
            Observer {
                when (it) {
                    is Result.Success -> {
                        moviesList.clear()
                        moviesList.addAll(it.data.result)
                        _movies.value = ArrayList(moviesList)
                        _isLoading.value = false
                        Log.d("loading", "1")
                    }
                    is Result.Error -> {
                        if (moviesList.isEmpty()) {
                            moviesList.clear()
                            _movies.value = null
                            _isLoading.value = false
                            Log.d("loading", "2")
                        }
                        _isLoading.value = false
                        Log.d("loading", "3")
                    }

                    is Result.Empty -> {
                        moviesList.clear()
                        _movies.value = null
                        _isLoading.value = false
                        Log.d("loading", "4")
                    }

                    is Result.Loading -> {
                        _isLoading.value = false
                        Log.d("loading", "5")
                    }
                }
            }
        )


    }


    fun searchMovie(query: String) {
        _isLoading.value = false
        observe(
            movieDataSingleSourceOfTruth.fetchMovies(query),
            Observer {
                when (it) {

                    is Result.Success -> {
                        moviesList.clear()
                        moviesList.addAll(it.data.result)
                        _movies.value = ArrayList(moviesList)
                        _isLoading.value = false
                         Log.d("loading", "6")
                    }
                    is Result.Error -> {
                        if (moviesList.isEmpty()) {
                            moviesList.clear()
                            _movies.value = null
                            _isLoading.value = false
                        }
                        _isLoading.value = false
                    }

                    is Result.Empty -> {
                        moviesList.clear()
                        _movies.value = null
                        _isLoading.value = false
                    }

                    is Result.Loading -> {
                        _isLoading.value = true
                        Log.d("loading", "10")
                    }
                }
            }
        )
    }
}