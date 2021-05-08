package com.example.submission2jetpack.di

import android.content.Context
import com.example.submission2jetpack.data.ContentRepository
import com.example.submission2jetpack.data.remote.RemoteData

object Injection {
    fun provideContentRepository(context: Context): ContentRepository {
        val remoteData = RemoteData.getInstance()
        return ContentRepository.getInstance(remoteData)
    }
}