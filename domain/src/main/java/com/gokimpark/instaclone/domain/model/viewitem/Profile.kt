package com.gokimpark.instaclone.domain.model.viewitem

import com.gokimpark.instaclone.domain.model.User


class Profile(
    viewItemType: ViewItemType = ViewItemType.UNKNOWN,
    val user: User,
    val postCount: String = "",
    val followerCount: String = "",
    val followingCount: String = "",
    val tabs: List<Tab> = emptyList(),
) : ViewItem(viewItemType) {

    class Tab(
        val iconUrl: String = "",
        val title: String = "",
    )

}