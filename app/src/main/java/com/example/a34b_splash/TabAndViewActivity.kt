package com.example.a34b_splash

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.a34b_splash.adapter.TabAdapter
import com.example.a34b_splash.databinding.ActivityTabAndViewBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabAndViewActivity : AppCompatActivity() {
    lateinit var tabAndViewActivityBinding :ActivityTabAndViewBinding
    var heading = arrayOf("Profile","Notification","Home","Search")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        tabAndViewActivityBinding = ActivityTabAndViewBinding.inflate(layoutInflater)
        setContentView(tabAndViewActivityBinding.root)

        setContentView(R.layout.activity_tab_and_view)

        var fragmentManager: FragmentManager= supportFragmentManager
        tabAndViewActivityBinding.viewPager.adapter=
            TabAdapter(fragmentManager,lifecycle)

        TabLayoutMediator(tabAndViewActivityBinding.layouttab,tabAndViewActivityBinding.viewPager){
            tabs,position -> tabs.text = heading[position]
        }.attach()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}