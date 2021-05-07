package com.example.submission2jetpack.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListTvShowResponse(
    @SerializedName("results")
    val result: List<TvShowResponse>
)
