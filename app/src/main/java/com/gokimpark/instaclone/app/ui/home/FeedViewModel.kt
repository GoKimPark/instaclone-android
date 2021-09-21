package com.gokimpark.instaclone.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gokimpark.instaclone.domain.model.User
import com.gokimpark.instaclone.domain.model.viewitem.Post
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FeedViewModel @Inject constructor() : ViewModel() {

    private val _post = MutableLiveData(
        Post(
            viewItemType = ViewItemType.POST,
            author = User(
                userName = "Author's userName",
                displayName = "Author's displayName",
                avatarUrl = "",
                profilePath = "",
            ),
            place = "Place"
        )
    )

    val post: LiveData<Post> = _post

}