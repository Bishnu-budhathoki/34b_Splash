package com.example.a34b_splash.adapter

    import androidx.fragment.app.Fragment
    import androidx.fragment.app.FragmentManager
    import androidx.lifecycle.Lifecycle
    import androidx.viewpager2.adapter.FragmentStateAdapter
    import com.example.a34b_splash.BlankFragment
    import com.example.a34b_splash.HomeFragment
    import com.example.a34b_splash.NotificationFragment
    import com.example.a34b_splash.ProfileFragment
    import com.example.a34b_splash.SearchFragment

class TabAdapter(
        var fragmentManager: FragmentManager,
        var lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int {
            return 3;
        }

        override fun createFragment(position: Int): Fragment {
            when(position){
                0-> return ProfileFragment()
                1-> return HomeFragment()
                2-> return SearchFragment()
                3-> return NotificationFragment()

                else->return BlankFragment()

        }

    }
}