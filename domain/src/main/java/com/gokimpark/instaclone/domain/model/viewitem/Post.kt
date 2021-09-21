package com.gokimpark.instaclone.domain.model.viewitem

import com.gokimpark.instaclone.domain.model.User


class Post(
    viewItemType: ViewItemType = ViewItemType.UNKNOWN,
    val author: User,
    val place: String = "",
    val mainImageUrl: String = "",
) : ViewItem(viewItemType)