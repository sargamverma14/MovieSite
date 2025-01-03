package com.example.movieapi.movies

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.api.adaptorviewpager.ViewPagerAdaptor
import com.example.api.fragments.fragment1
import com.example.api.fragments.fragment2
import com.example.api.fragments.fragment3
import com.example.movieapi.R
import com.google.android.material.tabs.TabLayout

class MovieActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_movie)
        pager = findViewById(R.id.viewpager)
        tab = findViewById(R.id.tab)

        val adaptor = ViewPagerAdaptor(supportFragmentManager)
        adaptor.addFragment(fragment1(this),"Popular Movie")
        adaptor.addFragment(fragment2(),"Popular Person")
        adaptor.addFragment(fragment3(),"Popular Show")

        pager.adapter = adaptor
        tab.setupWithViewPager(pager)
    }
}