package com.example.submission3jetpack.di

import android.content.Context
import com.example.submission3jetpack.data.source.ContentRepository
import com.example.submission3jetpack.data.source.local.LocalDataSource
import com.example.submission3jetpack.data.source.local.room.MovieDatabase
import com.example.submission3jetpack.data.source.remote.RemoteDataSource
import com.example.submission3jetpack.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ContentRepository {
        val database = MovieDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieAppDao())
        val appExecutors = AppExecutors()
        return ContentRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}