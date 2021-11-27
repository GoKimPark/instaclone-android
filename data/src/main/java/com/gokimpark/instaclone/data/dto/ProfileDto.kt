package com.gokimpark.instaclone.data.dto

import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType


class ProfileDto(
    viewItemType: ViewItemType? = null,
    val userName: String? = null,
    val displayName: String? = null,
    val avatarUrl: String? = null,
    val postCount: String? = null,
    val followerCount: String? = null,
    val followingCount: String? = null,
    val tabs: List<TabDto>? = null,
) : ViewItemDto(viewItemType) {

    class TabDto(
        val iconUrl: String? = null,
        val contentUrl: String? = null,
    ) : Dto()

}