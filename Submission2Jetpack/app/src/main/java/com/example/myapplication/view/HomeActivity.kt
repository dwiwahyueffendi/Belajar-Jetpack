package com.example.myapplication.view

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    companion object {
        @StringRes
        private val TAB_TITLES = listOf(R.string.movie, R.string.tv_show)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.elevation = 0f
        supportActionBar?.title = resources.getString(R.string.app_name)

        val sectionPagerAdapter = SectionPagerAdapter(supportFragmentManager)
        binding.apply {
            viewPager.adapter = sectionPagerAdapter
            tabs.setupWithViewPager(viewPager)
        }
    }

    inner class SectionPagerAdapter(
        fm: FragmentManager
    ) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> MovieFragment()
                1 -> TvShowFragment()
                else -> Fragment()
            }

        override fun getPageTitle(position: Int): CharSequence {
            return resources.getString(TAB_TITLES[position])
        }

        override fun getCount(): Int = TAB_TITLES.size
    }
}
