package com.gokimpark.instaclone.domain.model.viewitem

class Thumbnail(
    viewItemType: ViewItemType = ViewItemType.UNKNOWN,
    val postUrl: String = "",
    val imageUrl: String = "",
    val postType: PostType = PostType.SINGLE_IMAGE
) : ViewItem(viewItemType)