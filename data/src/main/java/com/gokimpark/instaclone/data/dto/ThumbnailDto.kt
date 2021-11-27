package com.gokimpark.instaclone.data.dto

import com.gokimpark.instaclone.domain.model.viewitem.PostType


class ThumbnailDto(
    val postUrl: String?,
    val imageUrl: String?,
    val postType: PostType?,
) : Dto()