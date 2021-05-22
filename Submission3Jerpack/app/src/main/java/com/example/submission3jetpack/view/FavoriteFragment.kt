package com.example.submission3jetpack.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.submission3jetpack.adapter.FavoritePagerAdapter
import com.example.submission3jetpack.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private var _fragmentFavoriteBinding : FragmentFavoriteBinding? = null
    private val binding get() = _fragmentFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoritePagerAdapter = FavoritePagerAdapter(requireContext(), requireActivity().supportFragmentManager)
        binding?.viewPager?.adapter = favoritePagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentFavoriteBinding = null
    }
}