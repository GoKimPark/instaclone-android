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
                userName = "user1",
                displayName = "user1's displayName",
                avatarUrl = "https://images.unsplash.com/photo-1565038941323-e5ceac0fcde2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=880&q=80",
                profilePath = "",
            ),
            place = "Place"
        )
    )
    val post: LiveData<Post> = _post

}