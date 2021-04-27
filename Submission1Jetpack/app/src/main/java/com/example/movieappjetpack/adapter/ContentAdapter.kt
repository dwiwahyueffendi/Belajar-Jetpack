package com.example.movieappjetpack.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.movieappjetpack.R
import com.example.movieappjetpack.data.ContentEntity
import com.example.movieappjetpack.databinding.ListItemBinding
import com.example.movieappjetpack.view.DetailActivity
import java.util.ArrayList

class ContentAdapter: RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {
    private var listContent = ArrayList<ContentEntity>()

    fun setContent(content: List<ContentEntity>?) {
        if (content == null) return

        if (content.size > 0){
            listContent.clear()
        }
        listContent.addAll(content)

        notifyDataSetChanged()
    }

    inner class ContentViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(content: ContentEntity){
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DETAIL, content.id)
                itemView.context.startActivity(intent)
            }

            binding.apply{
                tvTitle.text = content.title
                tvRelease.text = content.dateRelease

                val requestOptions = RequestOptions()
                requestOptions.placeholder(R.drawable.ic_loading)
                requestOptions.error(R.drawable.ic_error)

                Glide.with(itemView.context)
                    .load(content.image)
                    .apply(RequestOptions()
                        .placeholder(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(ivContent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(listContent[position])
    }

    override fun getItemCount(): Int = listContent.size
}