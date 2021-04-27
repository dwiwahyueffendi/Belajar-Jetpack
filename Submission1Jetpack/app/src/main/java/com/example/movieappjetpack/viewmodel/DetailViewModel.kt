package com.example.movieappjetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movieappjetpack.data.ContentEntity
import com.example.movieappjetpack.data.dummy.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var id: String
    private lateinit var endPoint: ContentEntity
    private val showMovie = DataDummy.generateDummyMovie()
    private val showTvShow = DataDummy.generateDummyTvShow()

    fun setContentDetail(id: String){
        this.id = id
    }

    fun getContentDetail(): ContentEntity{
        for (idLooping in showMovie){
            if (idLooping.id == id){
                endPoint = idLooping
            }
        }

        for (idLooping in showTvShow){
            if (idLooping.id == id){
                endPoint = idLooping
            }
        }

        return endPoint
    }
}