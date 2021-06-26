package com.gokimpark.instaclone.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gokimpark.instaclone.R
import com.gokimpark.instaclone.databinding.FragmentHomeBinding
import com.gokimpark.instaclone.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    // https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        activity?.run {
            onBackPressedDispatcher.addCallback(this) {
                parentFragment?.run { findNavController().popBackStack() }
            }
        }

        profileViewModel.profile.observe(this) {
            with(binding.header) {
                postCount.setData(it.postCount, "Posts")
                followerCount.setData(it.followerCount, "Followers")
                followingCount.setData(it.followingCount, "Following")
                avatar.setImageResource(R.drawable.ic_launcher_foreground)
            }
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}