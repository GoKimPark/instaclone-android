package com.gokimpark.instaclone.app.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by viewModels({ parentFragment ?: this })

    private var _view: ProfileView? = null
    private val view get() = _view!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = ProfileView(requireContext())

        activity?.run {
            onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                parentFragment?.run { findNavController().popBackStack() }
            }
        }

        profileViewModel.profile.observe(viewLifecycleOwner) { view.setData(it) }

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }

}