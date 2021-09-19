package com.gokimpark.instaclone.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType
import com.gokimpark.instaclone.domain.usecase.ProfileUseCase


class ProfileViewModel(
    private val profileUseCase: ProfileUseCase
) : ViewModel() {

    private val _profile = MutableLiveData(
        Profile(
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
    )

    val profile: LiveData<Profile> = _profile

    fun getProfile(userName: String) {
        profileUseCase.getProfile(
            userName = userName,
            callback = { _profile.postValue(it) },
            errorCallback = { }
        )
    }

}