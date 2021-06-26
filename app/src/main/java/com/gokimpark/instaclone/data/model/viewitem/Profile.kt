package com.gokimpark.instaclone.data.model.viewitem


class Profile(
    viewItemType: ViewItemType = ViewItemType.UNKNOWN,
    val nickname: String = "",
    val avatarUrl: String = "",
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