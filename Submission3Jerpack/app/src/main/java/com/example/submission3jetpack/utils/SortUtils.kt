package com.example.submission3jetpack.utils

import androidx.sqlite.db.SimpleSQLiteQuery
import java.lang.StringBuilder

object SortUtils {
    const val BEST_RATING = "Best"
    const val WORST_RATING = "Worst"
    const val DEFAULT = "Default"
    const val MOVIE_ENTITIES = "movieEntities"
    const val TV_SHOW_ENTITIES = "tvShowEntities"

    fun getSortedQuery(filter: String, tableName: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM $tableName ")
        when(filter) {
            DEFAULT -> {
                simpleQuery.append("ORDER BY id ASC")
            }
            BEST_RATING -> {
                simpleQuery.append("ORDER BY voteAverage DESC")
            }
            WORST_RATING -> {
                simpleQuery.append("ORDER BY voteAverage ASC")
            }
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}