package com.example.a34b_splash

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a34b_splash.databinding.ActivityDashBoard2Binding
import com.google.android.material.navigation.NavigationView

class DashBoardActivity2 : AppCompatActivity(), NavigationView.
OnNavigationItemSelectedListener {

    lateinit var dashBoardBinding: ActivityDashBoard2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dash_board2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.home -> {
                title = "Home"
                supportFragmentManager.beginTransaction().
                replace(R.id.frameLayout, HomeFragment()).
                commit()
            }
            R.id.search -> supportFragmentManager.beginTransaction().
            replace(R.id.frameLayout, SearchFragment()).commit()

            R.id.profile -> supportFragmentManager.beginTransaction().
            replace(R.id.frameLayout, ProfileFragment()).commit()

            R.id.notification -> supportFragmentManager.beginTransaction().
            replace(R.id.frameLayout, NotificationFragment()).commit()

            R.id.home -> supportFragmentManager.beginTransaction().
            replace(R.id.frameLayout, HomeFragment()).commit()

        }
        dashBoardBinding.main.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (dashBoardBinding.main.isDrawerOpen(GravityCompat.START)) {
            dashBoardBinding.main.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed() // Move this line inside the else block
        }
    }
}
