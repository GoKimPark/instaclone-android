package com.gokimpark.instaclone.app.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokimpark.instaclone.domain.model.User
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType
import com.gokimpark.instaclone.domain.usecase.ProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase
) : ViewModel() {

    private val _profile = MutableLiveData(
        Profile(
            viewItemType = ViewItemType.UNKNOWN,
            user = User(
                userName = "-",
                displayName = "-",
                avatarUrl = "",
                profilePath = "",
            ),
            postCount = "-",
            followerCount = "-",
            followingCount = "-",
            tabs = emptyList()
        )
    )
    val profile: LiveData<Profile> = _profile


    private val _thumbnails = MutableLiveData<List<Thumbnail>>(emptyList()).apply {
        profile.observeForever {
            if (it.tabs.isNotEmpty()) {
                viewModelScope.launch {
                    postValue(profileUseCase.getTabContents(it.tabs.first()))
                }
            }
        }
    }
    val thumbnails: LiveData<List<Thumbnail>> = _thumbnails


    fun getProfile(user: User) {
        profileUseCase.getProfile(
            user = user,
            callback = { _profile.postValue(it) },
            errorCallback = { Log.d("profile", it) }
        )
    }

}