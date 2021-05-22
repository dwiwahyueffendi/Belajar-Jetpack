package com.example.submission3jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3jetpack.R
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.databinding.ListItemBinding
import com.example.submission3jetpack.network.NetworkInfo.IMAGE_URL
import com.squareup.picasso.Picasso

class FavoriteTvShowAdapter: PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(
    DIFF_CALLBACK
) {
    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val itemMovieTvShowBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowViewHolder(itemMovieTvShowBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    inner class FavoriteTvShowViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvRating.text = tvShow.voteAverage.toString()

                Picasso.get()
                    .load("${IMAGE_URL}w185${tvShow.posterPath}")
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .into(imgPoster)

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(tvShow.id)
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(tvShowId: String)
    }
}