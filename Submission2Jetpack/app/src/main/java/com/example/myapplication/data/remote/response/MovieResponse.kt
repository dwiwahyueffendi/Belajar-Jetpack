package com.example.myapplication.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    val id: Int = 0,
    @SerializedName("overview")
    val desc: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    val title: String? = null,
    @SerializedName("vote_average")
    val voteAverage: String? = null
)