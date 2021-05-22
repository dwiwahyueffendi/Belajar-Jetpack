package com.example.submission3jetpack.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission3jetpack.data.source.MovieAppRepository
import com.example.submission3jetpack.di.Injection
import com.example.submission3jetpack.viewmodel.DetailMovieViewModel
import com.example.submission3jetpack.viewmodel.DetailTvShowViewModel
import com.example.submission3jetpack.viewmodel.FavoriteMovieViewModel
import com.example.submission3jetpack.viewmodel.FavoriteTvShowViewModel
import com.example.submission3jetpack.viewmodel.MovieViewModel
import com.example.submission3jetpack.viewmodel.TvShowViewModel

class ViewModelFactory private constructor(private val movieAppRepository: MovieAppRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                return FavoriteMovieViewModel(movieAppRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                return FavoriteTvShowViewModel(movieAppRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}