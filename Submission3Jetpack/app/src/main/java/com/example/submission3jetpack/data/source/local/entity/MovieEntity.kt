package com.example.submission3jetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntities")
data class MovieEntity (

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: String,

        @ColumnInfo(name = "posterPath")
        var posterPath: String? = "",

        @ColumnInfo(name = "title")
        var title: String? = "",

        @ColumnInfo(name = "backdropPath")
        var backdropPath: String? = "",

        @ColumnInfo(name = "overview")
        var overview: String? = "",

        @ColumnInfo(name = "releaseDate")
        var releaseDate: String? = "",

        @ColumnInfo(name = "voteAverage")
        var voteAverage: String? = "",

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean = false
)