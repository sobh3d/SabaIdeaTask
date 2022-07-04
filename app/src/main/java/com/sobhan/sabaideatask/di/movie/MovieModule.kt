package com.sobhan.sabaideatask.di.movie

import com.sobhan.sabaideatask.data.api.RetrofitProvider
import com.sobhan.sabaideatask.data.repositories.MovieServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {
    @Provides
    @Singleton
    fun provideMovieApiServices(retrofit: Retrofit): MovieServices {
        return RetrofitProvider.provideService(
            retrofit,
            MovieServices::class.java
        )
    }


}