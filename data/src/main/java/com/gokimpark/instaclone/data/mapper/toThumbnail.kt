package com.gokimpark.instaclone.data.mapper

import com.gokimpark.instaclone.data.dto.ThumbnailDto
import com.gokimpark.instaclone.domain.model.viewitem.PostType
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail

fun ThumbnailDto.toThumbnail() = Thumbnail(
    postUrl = postUrl ?: "",
    imageUrl = imageUrl ?: "",
    postType = postType ?: PostType.SINGLE_IMAGE,
)