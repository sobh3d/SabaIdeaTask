package com.sobhan.sabaideatask.data.repositories.movie


import com.sobhan.sabaideatask.data.repositories.MovieServices
import com.sobhan.sabaideatask.data.utils.ApiErrorHandler
import com.sobhan.sabaideatask.data.utils.BaseAPIDataSource
import com.sobhan.sabaideatask.ui.utils.DispatcherProvider
import javax.inject.Inject

class MovieApiDataSource @Inject constructor(
    private val service: MovieServices,
    errorHandler: ApiErrorHandler,
    dispatcher: DispatcherProvider
) : BaseAPIDataSource(errorHandler, dispatcher) {

    suspend fun getMovies(query:String) = getResult {
        service.getMovies(query)
    }
}