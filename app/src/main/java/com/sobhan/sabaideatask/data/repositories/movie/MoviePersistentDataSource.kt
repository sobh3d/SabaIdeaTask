package com.sobhan.sabaideatask.data.repositories.movie


import com.sobhan.sabaideatask.data.persistent.MovieDao
import com.sobhan.sabaideatask.model.Datum
import com.sobhan.sabaideatask.ui.utils.DispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import com.sobhan.sabaideatask.data.utils.Result

@Singleton
class MoviePersistentDataSource @Inject constructor(
    private val movieDao: MovieDao,
    private val dispatcher: DispatcherProvider
) {

    suspend fun getMessagesInstantly(): Result<List<Datum>> =
        withContext(dispatcher.io()) {
            val data = movieDao.getAllInstantly()
            if (data.isEmpty().not()) {
                Result.Success(data)
            } else {
                Result.Empty
            }
        }




    suspend fun dropAndInsertAllMovies(movies: List<Datum>) =
        withContext(dispatcher.io()) {
            movieDao.dropAndInsertAllMovies(movies)
        }


}