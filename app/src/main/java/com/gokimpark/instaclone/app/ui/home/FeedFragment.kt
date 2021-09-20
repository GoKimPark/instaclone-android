package com.gokimpark.instaclone.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.gokimpark.instaclone.R
import com.gokimpark.instaclone.databinding.FragmentFeedBinding


class FeedFragment : NavHostFragment() {

    private lateinit var feedViewModel: FeedViewModel

    // https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        _binding = FragmentFeedBinding.inflate(inflater, container, false)

        feedViewModel.post.observe(this) { post ->
            with(binding.postView.binding.header) {
                authorNickname.text = post.authorNickname
                authorNickname.setOnClickListener { landToProfileFragment(post.authorProfileUrl) }
                authorAvatar.setImageResource(R.drawable.ic_launcher_foreground)
                authorAvatar.setOnClickListener { landToProfileFragment(post.authorProfileUrl) }
                place.text = post.place
            }
            with(binding.postView.binding) {
                mainImage.setImageResource(R.drawable.ic_launcher_background)
            }
        }

        return binding.root
    }


    private fun landToProfileFragment(authorProfileUrl: String) {
        parentFragment?.run { findNavController().navigate(R.id.action_navigation_feed_to_naviation_profile) }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}