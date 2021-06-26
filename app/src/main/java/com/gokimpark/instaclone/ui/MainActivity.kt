package com.gokimpark.instaclone.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.gokimpark.instaclone.R
import com.gokimpark.instaclone.databinding.ActivityMainBinding
import com.gokimpark.instaclone.ui.dashboard.DashboardFragment
import com.gokimpark.instaclone.ui.home.HomeFragment
import com.gokimpark.instaclone.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var fragmentIndex = 0

    private lateinit var fragments: List<Pair<String, Fragment>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            fragmentIndex = savedInstanceState.getInt(BundleKey.FRAGMENT_INDEX.name)
        }

        fragments = listOf(
            HomeFragment::class.qualifiedName!! to HomeFragment(),
            DashboardFragment::class.qualifiedName!! to DashboardFragment(),
            NotificationsFragment::class.qualifiedName!! to NotificationsFragment()
        )

        supportFragmentManager.commit {
            fragments.forEach {
                add(R.id.nav_host_fragment, it.second, it.first)
                detach(it.second)
            }
            select(fragmentIndex)
        }

        // val navController = findNavController(R.id.nav_host_fragment)
        // // Passing each menu ID as a set of Ids because each
        // // menu should be considered as top level destinations.
        // val appBarConfiguration = AppBarConfiguration(
        //     setOf(
        //         R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
        //     )
        // )
        // setupActionBarWithNavController(navController, appBarConfiguration)
        // binding.navView.setupWithNavController(navController)
        binding.navView.menu.forEachIndexed { index, item ->
            item.setOnMenuItemClickListener {
                selectFragment(index)
                true
            }
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BundleKey.FRAGMENT_INDEX.name, fragmentIndex)
    }


    private fun selectFragment(index: Int) {
        supportFragmentManager.commit { select(index) }
    }


    private fun FragmentTransaction.select(index: Int) {
        detach(fragments[fragmentIndex].second)
        attach(fragments[index].second)
        fragmentIndex = index
        // replace(R.id.nav_host_fragment, fragments[index].second)
    }


    private enum class BundleKey {
        FRAGMENT_INDEX,
        ;
    }

}