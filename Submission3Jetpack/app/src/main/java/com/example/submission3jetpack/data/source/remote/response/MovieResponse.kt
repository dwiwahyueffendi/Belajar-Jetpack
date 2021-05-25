package com.example.submission3jetpack.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
	@field:SerializedName("results")
	val results: List<ListMovieResponse>
)
