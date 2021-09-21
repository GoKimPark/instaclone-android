package com.gokimpark.instaclone.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.gokimpark.instaclone.R
import com.gokimpark.instaclone.databinding.ActivityMainBinding
import com.gokimpark.instaclone.app.ui.dashboard.DashboardFragment
import com.gokimpark.instaclone.app.ui.home.HomeFragment
import com.gokimpark.instaclone.app.ui.notifications.NotificationsFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var fragmentIndex = 0

    private val fragments: List<Pair<String, Fragment>> = listOf(
        HomeFragment::class.qualifiedName!! to HomeFragment(),
        DashboardFragment::class.qualifiedName!! to DashboardFragment(),
        NotificationsFragment::class.qualifiedName!! to NotificationsFragment()
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            fragmentIndex = savedInstanceState.getInt(BundleKey.FRAGMENT_INDEX.name)
        }

        supportFragmentManager.commit {
            fragments.forEach {
                add(R.id.nav_host_fragment, it.second, it.first)
                detach(it.second)
            }
            select(fragmentIndex)
        }

        binding.navView.menu.forEachIndexed { index, item ->
            item.setOnMenuItemClickListener {
                selectFragment(index)
                false
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
    }


    private enum class BundleKey {
        FRAGMENT_INDEX,
        ;
    }

}