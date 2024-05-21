package com.example.a34b_splash

import android.app.Notification
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.a34b_splash.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity() {
    lateinit var dashBoardBinding: ActivityDashBoardBinding

    private fun replaceFragment(fragment:Fragment){
        var fragmentManager:FragmentManager = supportFragmentManager
        var fragmentTransaction:FragmentTransaction= fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dashBoardBinding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(dashBoardBinding.root)
        setContentView(R.layout.activity_dash_board)

        dashBoardBinding.bottomNavigationView.setOnItemReselectedListener {
            setContentView(dashBoardBinding.root)

            replaceFragment(HomeFragment())

            dashBoardBinding.bottomNavigationView.setOnItemReselectedListener {
                when (it.itemId) {
                    R.id.home -> replaceFragment(HomeFragment())
                    R.id.search -> replaceFragment(SearchFragment())
                    R.id.notification -> replaceFragment(NotificationFragment())
                    R.id.profile -> replaceFragment(ProfileFragment())
                    else -> {}

                }
                true

            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}