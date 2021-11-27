package com.gokimpark.instaclone.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.gokimpark.instaclone.R
import com.gokimpark.instaclone.app.ui.profile.ProfileViewModel
import com.gokimpark.instaclone.app.utility.loadInCircle
import com.gokimpark.instaclone.databinding.FragmentFeedBinding
import com.gokimpark.instaclone.domain.model.User
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FeedFragment : NavHostFragment() {

    private val feedViewModel: FeedViewModel by viewModels()
    private val profileViewModel: ProfileViewModel by viewModels()

    // https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        feedViewModel.post.observe(viewLifecycleOwner) { post ->
            with(binding.postView.binding.header) {
                authorNickname.text = post.author.displayName
                authorNickname.setOnClickListener { landToProfileFragment(post.author) }
                authorAvatar.loadInCircle(post.author.avatarUrl)
                authorAvatar.setOnClickListener { landToProfileFragment(post.author) }
                place.text = post.place
            }
            with(binding.postView.binding) {
                mainImage.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }


    private fun landToProfileFragment(user: User) {
        profileViewModel.getProfile(user)
        val direction = FeedFragmentDirections.actionNavigationFeedToNaviationProfile(user.userName)
        parentFragment?.run { findNavController().navigate(direction) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}