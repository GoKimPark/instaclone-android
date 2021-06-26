package com.gokimpark.instaclone.data.dto

import com.gokimpark.instaclone.data.model.viewitem.ViewItem


class FeedResponseDto : ResponseDto() {
    val feeds: List<ViewItem> = emptyList()
}