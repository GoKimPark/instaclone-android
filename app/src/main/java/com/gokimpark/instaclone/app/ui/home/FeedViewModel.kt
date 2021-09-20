package com.gokimpark.instaclone.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gokimpark.instaclone.domain.model.viewitem.Post
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType


class FeedViewModel : ViewModel() {

    private val _post = MutableLiveData<Post>().apply {
        value = Post(
            viewItemType = ViewItemType.POST,
            authorNickname = "Author's nickname",
            place = "Place"
        )
    }

    val post: LiveData<Post> = _post

}