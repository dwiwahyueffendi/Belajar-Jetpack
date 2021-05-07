package com.example.submission2jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.submission2jetpack.data.local.MovieEntity
import com.example.submission2jetpack.databinding.ListItemBinding
import com.example.submission2jetpack.network.NetworkInfo.IMAGE_URL

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private var movie = ArrayList<MovieEntity>()

    inner class MovieViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.title
                tvRelease.text = movie.releaseDate
                tvRating.text = movie.voteAverage.toString()

                Glide.with((itemView))
                    .load(IMAGE_URL + movie.posterPath)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(ivContent)

                itemView.setOnClickListener {onItemClickCallback.onItemClicked(movie.id)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemListMovie = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemListMovie)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movie[position])
    }

    override fun getItemCount(): Int = movie.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovies(listMovie: List<MovieEntity>){
        if (listMovie.isNullOrEmpty()) return
        this.movie.clear()
        this.movie.addAll(listMovie)
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: Int)
    }
}