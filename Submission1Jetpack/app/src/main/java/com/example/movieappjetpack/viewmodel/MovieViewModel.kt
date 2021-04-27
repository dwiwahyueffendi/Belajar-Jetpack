package com.example.movieappjetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movieappjetpack.data.ContentEntity
import com.example.movieappjetpack.data.dummy.DataDummy

class MovieViewModel: ViewModel() {
    fun getContentMovie(): List<ContentEntity> = DataDummy.generateDummyMovie()
}