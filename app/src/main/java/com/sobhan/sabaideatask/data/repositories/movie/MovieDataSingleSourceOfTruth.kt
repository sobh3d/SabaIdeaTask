package com.sobhan.sabaideatask.data.repositories.movie



import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.liveData
import com.sobhan.sabaideatask.data.utils.ApiResult
import com.sobhan.sabaideatask.ui.utils.DispatcherProvider
import javax.inject.Inject
import javax.inject.Singleton
import com.sobhan.sabaideatask.data.utils.Result
import com.sobhan.sabaideatask.model.Datum

@Singleton
class MovieDataSingleSourceOfTruth @Inject constructor(
    private val movieApiDataSource: MovieApiDataSource,
    private val moviePersistentDataSource: MoviePersistentDataSource,
    private val dispatcher: DispatcherProvider
) {
    fun fetchMovies(query: String): LiveData<Result<MovieResult>> =
        liveData(dispatcher.ui()) {
            emit(Result.Loading)
            val source = moviePersistentDataSource.getMovieInstantly()
            if (source is Result.Success) {
                emit(Result.Success(MovieResult(source.data)))
            }
            emit(Result.Loading)
            apiRequest(query)


        }


    fun getMovies():LiveData<Result<MovieResult>> =
        liveData(dispatcher.ui()){
            emit(Result.Loading)
            val source = moviePersistentDataSource.getMovieInstantly()
            if(source is Result.Success){
                emit(Result.Success(MovieResult(source.data)))
            }
        }


    private suspend fun LiveDataScope<Result<MovieResult>>.apiRequest(query:String) {
        when (val apiRes = movieApiDataSource.getMovies(query)) {
            is ApiResult.Success -> {
                val data = apiRes.data
                if (data != null) {
                    val movies = data.data
                    when {
                        movies.isEmpty().not() -> {
                            moviePersistentDataSource.dropAndInsertAllMovies(movies)
                            val source = moviePersistentDataSource.getMovieInstantly()
                            if(source is Result.Success){
                                emit(Result.Success(MovieResult(source.data)))
                            }


                        }
                    }

                }
            }
            is ApiResult.Error -> {
                val result = Result.Error(apiRes.error)
                emit(result)
            }
        }
    }


    data class MovieResult(
        val result: List<Datum>,
    )



}