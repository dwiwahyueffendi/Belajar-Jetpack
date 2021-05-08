package com.example.myapplication.data.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ContentEntity(
    val id: Int = 0,
    val title: String? = null,
    val desc: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null
) : Parcelable