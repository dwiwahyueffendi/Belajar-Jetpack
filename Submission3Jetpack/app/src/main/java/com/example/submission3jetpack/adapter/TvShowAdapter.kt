package com.example.submission3jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.submission3jetpack.R
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.databinding.ListItemBinding
import com.example.submission3jetpack.network.NetworkInfo.IMAGE_URL

class TvShowAdapter: PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {
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

    inner class TvShowViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TvShowEntity) {
            with(binding) {
                val requestOptions = RequestOptions()
                requestOptions.placeholder(R.drawable.ic_loading)
                requestOptions.error(R.drawable.ic_error)

                Glide.with((itemView))
                    .load(IMAGE_URL + data.posterPath)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(ivPosterPath)

                tvTitle.text = data.name
                tvTitle.isSelected = true
                tvTitle.isSingleLine = true
                tvRelease.text = data.firstAirDate
                tvRating.text = data.voteAverage.toString()

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(data.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemMovieTvShowBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemMovieTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) { holder.bind(data) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(tvShowId: String)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}