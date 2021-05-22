package com.example.submission3jetpack.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.submission3jetpack.data.source.local.entity.MovieEntity
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity

@Database(
    entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false
)

abstract class MovieAppDatabase: RoomDatabase() {

    abstract fun movieAppDao(): MovieAppDao

    companion object {
        @Volatile
        private var INSTANCE: MovieAppDatabase? = null

        fun getInstance(context: Context): MovieAppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    MovieAppDatabase::class.java,
                    "MovieApp.db").build()
            }
    }
}