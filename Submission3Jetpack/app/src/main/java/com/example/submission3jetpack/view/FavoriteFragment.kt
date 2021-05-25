package com.example.submission3jetpack.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.submission3jetpack.R
import com.example.submission3jetpack.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvShow)
    }

    private var _fragmentFavoriteBinding : FragmentFavoriteBinding? = null
    private val binding get() = _fragmentFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoritePagerAdapter = FavoritePagerAdapter(requireContext(), requireActivity().supportFragmentManager)
        binding?.apply {
            viewPager.adapter = favoritePagerAdapter
            tabs.setupWithViewPager(viewPager)
        }
    }

    inner class FavoritePagerAdapter(private val context: Context, fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> FavoriteMovieFragment()
                1 -> FavoriteTvShowFragment()
                else -> Fragment()
            }

        override fun getPageTitle(position: Int): CharSequence = context.resources.getString(TAB_TITLES[position])

        override fun getCount(): Int = TAB_TITLES.size
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentFavoriteBinding = null
    }
}