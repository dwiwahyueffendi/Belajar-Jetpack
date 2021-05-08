package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.ContentAdapter
import com.example.myapplication.adapter.DataCallback
import com.example.myapplication.data.local.ContentEntity
import com.example.myapplication.databinding.FragmentContentBinding
import com.example.myapplication.network.NetworkInfo.TYPE_TV_SHOW
import com.example.myapplication.viewmodel.TvShowViewModel
import com.example.myapplication.viewmodel.factory.ViewModelFactory

class TvShowFragment : Fragment(), DataCallback {

    private lateinit var viewModel: TvShowViewModel
    private lateinit var binding: FragmentContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        val contentAdapter = ContentAdapter(this@TvShowFragment)

        viewModel.getListTvShow().observe(viewLifecycleOwner, Observer { tvShow ->
            binding.apply {
                rvContent.adapter.let { adapter ->
                    when (adapter) {
                        is ContentAdapter -> adapter.setContent(tvShow)
                    }
                }
            }
        })

        with(binding.rvContent) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = contentAdapter
        }
    }

    override fun onItemClicked(content: ContentEntity) {
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_ID, content.id)
                .putExtra(DetailActivity.EXTRA_CATEGORY, TYPE_TV_SHOW)
        )
    }
}