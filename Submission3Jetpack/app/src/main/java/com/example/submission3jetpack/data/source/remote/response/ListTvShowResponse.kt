package com.example.submission3jetpack.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTvShowResponse(
    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("vote_average")
    val voteAverage: String,

    @field:SerializedName("name")
    val name: String,
)
