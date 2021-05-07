package com.example.submission2jetpack.data.local

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val id: Int,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double
): Parcelable
