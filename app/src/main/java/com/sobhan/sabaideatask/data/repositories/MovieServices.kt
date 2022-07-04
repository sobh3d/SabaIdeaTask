package com.sobhan.sabaideatask.data.repositories



import com.sobhan.sabaideatask.data.model.MovieResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieServices {
    @GET("movie/movie/list/tagid/1000300/text/{Query}/sug/on")
    suspend fun getMovies(@Path("Query") query:String): Response<MovieResponseWrapper>
}