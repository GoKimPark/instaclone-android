package com.gokimpark.instaclone.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gokimpark.instaclone.data.model.viewitem.Profile
import com.gokimpark.instaclone.data.model.viewitem.ViewItemType


class ProfileViewModel : ViewModel() {

    private val _profile = MutableLiveData<Profile>().apply {
        value = Profile(
            viewItemType = ViewItemType.THUMBNAIL,
            nickname = "Nickname",
            followerCount = "16",
            followingCount = "32",
            postCount = "64",
            tabs = listOf(
                Profile.Tab(
                    title = "Posts"
                ),
                Profile.Tab(
                    title = "Tagged"
                )
            )
        )
    }

    val profile: LiveData<Profile> = _profile

}