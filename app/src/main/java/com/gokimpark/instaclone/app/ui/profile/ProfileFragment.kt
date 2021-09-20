package com.gokimpark.instaclone.app.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    private var _view: ProfileView? = null
    private val view get() = _view!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _view = ProfileView(requireContext())

        activity?.run {
            onBackPressedDispatcher.addCallback(this) {
                parentFragment?.run { findNavController().popBackStack() }
            }
        }

        profileViewModel.profile.observe(this) { view.setData(it) }

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }

}