package com.example.movieappjetpack.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappjetpack.R
import com.example.movieappjetpack.adapter.ContentAdapter
import com.example.movieappjetpack.databinding.FragmentTvShowBinding
import com.example.movieappjetpack.viewmodel.TvShowViewModel


class TvShowFragment: Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTvShowBinding.bind(view)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val content = viewModel.getContentTvShow()

            val tvShowAdapter = ContentAdapter()
            tvShowAdapter.setContent(content)

            binding.apply {
                rvListTvShow.layoutManager = LinearLayoutManager(context)
                rvListTvShow.setHasFixedSize(true)
                rvListTvShow.adapter = tvShowAdapter
            }
        }
    }
}