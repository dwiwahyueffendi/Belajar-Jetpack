package com.example.submission3jetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvShowEntities")
data class TvShowEntity (

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "posterPath")
    var posterPath: String? = "",

    @ColumnInfo(name = "name")
    var name: String? = "",

    @ColumnInfo(name = "backdropPath")
    var backdropPath: String? = "",

    @ColumnInfo(name = "overview")
    var overview: String? = "",

    @ColumnInfo(name = "firstAirDate")
    var firstAirDate: String? = "",

    @ColumnInfo(name = "voteAverage")
    var voteAverage: String? = "",

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)