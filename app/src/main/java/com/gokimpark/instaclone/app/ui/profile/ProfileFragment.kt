package com.gokimpark.instaclone.app.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gokimpark.instaclone.domain.model.User
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by viewModels()

    private var _view: ProfileView? = null
    private val view get() = _view!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = ProfileView(requireContext())
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            val args = ProfileFragmentArgs.fromBundle(bundle)
            val user = User(
                userName = args.user,
                displayName = "",
                avatarUrl =  "",
                profilePath = "",
            )
            profileViewModel.getProfile(user)
        }

        profileViewModel.profile.observe(viewLifecycleOwner) {
            this.view.setData(it)
        }

        activity?.run {
            onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                parentFragment?.run { findNavController().popBackStack() }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }

}