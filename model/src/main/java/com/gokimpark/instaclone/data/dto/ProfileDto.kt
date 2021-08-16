package com.gokimpark.instaclone.data.dto


class ProfileDto(
    viewItemType: String? = null,
    val nickname: String? = null,
    val avatarUrl: String? = null,
    val postCount: String? = null,
    val followerCount: String? = null,
    val followingCount: String? = null,
    val tabs: List<TabDto>? = null,
) : ViewItemDto(viewItemType) {

    class TabDto(
        val iconUrl: String? = null,
        val title: String? = null,
    ) : Dto()

}