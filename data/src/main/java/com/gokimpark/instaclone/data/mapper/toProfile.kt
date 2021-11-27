package com.gokimpark.instaclone.data.mapper

import com.gokimpark.instaclone.data.dto.ProfileDto
import com.gokimpark.instaclone.domain.model.User
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType


fun ProfileDto.toProfile() = Profile(
    viewItemType = viewItemType ?: ViewItemType.UNKNOWN,
    user = User(
        userName = userName ?: "",
        displayName = displayName ?: "",
        avatarUrl = avatarUrl ?: "",
        profilePath = ""
    ),
    postCount = postCount ?: "",
    followerCount = followerCount ?: "",
    followingCount = followingCount ?: "",
    tabs = tabs.emptyFallbackMap(ProfileDto.TabDto::toTab),
)


fun ProfileDto.TabDto.toTab() = Profile.Tab(
    iconUrl = iconUrl ?: "",
    contentUrl = contentUrl ?: "",
)