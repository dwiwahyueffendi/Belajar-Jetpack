package com.example.myapplication.di

import com.example.myapplication.data.ContentCatalogRepository
import com.example.myapplication.data.remote.RemoteDataSource

object Injection {

    fun provideCatalogRepository(): ContentCatalogRepository {
        val remoteData = RemoteDataSource.getInstance()
        return ContentCatalogRepository.getInstance(remoteData)
    }
}