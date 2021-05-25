package com.example.submission3jetpack.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3jetpack.adapter.TvShowAdapter
import com.example.submission3jetpack.data.source.local.entity.TvShowEntity
import com.example.submission3jetpack.databinding.FragmentTvShowBinding
import com.example.submission3jetpack.viewmodel.TvShowViewModel
import com.example.submission3jetpack.viewmodel.factory.ViewModelFactory
import com.example.submission3jetpack.vo.Resource
import com.example.submission3jetpack.vo.Status

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? =  null
    private val binding get() = _binding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var contentAdapter : TvShowAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())

            showInterface("LOADING")

            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            contentAdapter = TvShowAdapter()
            viewModel.getTvShows().observe(viewLifecycleOwner, tvShowObserver)

            setupUserInterface()
        }
    }

    fun showInterface(key: String){
        if (key == "LOADING"){
            binding?.apply {
                progressBar.visibility = View.VISIBLE
            }
        } else if (key == "SUCCESS"){
            binding?.apply {
                progressBar.visibility = View.GONE
            }
        } else if (key == "ERROR"){
            binding?.apply {
                progressBar.visibility = View.GONE
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupUserInterface() {
        binding?.let {
            with(it.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = contentAdapter
            }
        }

        contentAdapter.setOnItemClickCallback(object : TvShowAdapter.OnItemClickCallback {
            override fun onItemClicked(tvShowId: String) {
                val intent = Intent(context, DetailTvShowActivity::class.java).apply {
                    putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShowId)
                }
                startActivity(intent)
            }
        })
    }

    private val tvShowObserver = Observer<Resource<PagedList<TvShowEntity>>> { listTvShows ->
        if ( listTvShows != null) {
            when ( listTvShows.status) {
                Status.LOADING -> showInterface("LOADING")
                Status.SUCCESS -> {
                    showInterface("SUCCESS")
                    contentAdapter.submitList( listTvShows.data)
                }
                Status.ERROR -> showInterface("ERROR")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}