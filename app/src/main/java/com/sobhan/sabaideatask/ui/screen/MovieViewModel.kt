package com.sobhan.sabaideatask.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sobhan.sabaideatask.data.repositories.movie.MovieDataSingleSourceOfTruth
import com.sobhan.sabaideatask.model.Datum
import com.sobhan.sabaideatask.ui.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.sobhan.sabaideatask.data.utils.Result

@HiltViewModel
class MovieViewModel @Inject constructor(
    private var movieDataSingleSourceOfTruth: MovieDataSingleSourceOfTruth
) : BaseViewModel() {

    private val _movies = MutableLiveData<List<Datum>>()
    val movies: LiveData<List<Datum>> = _movies
    private val moviesList: MutableList<Datum> = ArrayList()

    init {

        observe(
            movieDataSingleSourceOfTruth.fetchMovies("yuu"),
            Observer {
                when (it) {
                    is Result.Success -> {
                        moviesList.clear()
                        moviesList.addAll(it.data.result)
                        _movies.value = ArrayList(moviesList)
                    }
                    is Result.Error -> {
                        if (moviesList.isEmpty()) {
                            moviesList.clear()
                            _movies.value = null
                        }
                    }

                    is Result.Empty -> {
                        moviesList.clear()
                        _movies.value = null
                    }

                    else -> {
                    }
                }
            }
        )


    }


    fun searchMovie(query:String){
        observe(
            movieDataSingleSourceOfTruth.fetchMovies(query),
            Observer {
                when (it) {
                    is Result.Success -> {
                        moviesList.clear()
                        moviesList.addAll(it.data.result)
                        _movies.value = ArrayList(moviesList)
                    }
                    is Result.Error -> {
                        if (moviesList.isEmpty()) {
                            moviesList.clear()
                            _movies.value = null
                        }
                    }

                    is Result.Empty -> {
                        moviesList.clear()
                        _movies.value = null
                    }

                    else -> {
                    }
                }
            }
        )
    }
}