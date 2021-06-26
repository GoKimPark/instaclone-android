package com.gokimpark.instaclone.data.model.viewitem


class Post(
    viewItemType: ViewItemType = ViewItemType.UNKNOWN,
    val authorNickname: String = "",
    val authorAvatarUrl: String = "",
    val authorProfileUrl: String = "",
    val place: String = "",
    val mainImageUrl: String = "",
) : ViewItem(viewItemType)