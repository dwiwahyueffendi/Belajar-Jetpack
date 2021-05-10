package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.data.local.ContentEntity
import com.example.myapplication.databinding.ListItemBinding
import com.example.myapplication.network.NetworkInfo.IMAGE_URL

class ContentAdapter(private val callback: DataCallback) : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    private val listContent = ArrayList<ContentEntity>()

    fun setContent(content: List<ContentEntity>?) {
        if (content.isNullOrEmpty()) return
        listContent.clear()
        listContent.addAll(content)
        notifyDataSetChanged()
    }

    inner class ContentViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ContentEntity) {
            with(binding) {
                val requestOptions = RequestOptions()
                requestOptions.placeholder(R.drawable.ic_account)
                requestOptions.error(R.drawable.ic_error)

                Glide.with((itemView))
                    .load(IMAGE_URL + data.posterPath)
                    .apply(RequestOptions()
                        .placeholder(R.drawable.ic_account)
                        .error(R.drawable.ic_error))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(ivContent)

                tvTitle.text = data.title
                tvRelease.text = data.releaseDate
                tvRating.text = data.voteAverage

                cardItem.setOnClickListener { callback.onItemClicked(data) }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val itemListContent = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(itemListContent)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(listContent[position])
    }

    override fun getItemCount(): Int = listContent.size

}