package com.sobhan.sabaideatask.di.persistent

import android.content.Context
import com.sobhan.sabaideatask.data.persistent.AppDatabase
import com.sobhan.sabaideatask.data.persistent.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistentModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getAppDataBase(context)
    }

    @Provides
    @Singleton
    fun provideMessageDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }


}