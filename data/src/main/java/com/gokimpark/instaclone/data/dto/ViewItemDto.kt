package com.gokimpark.instaclone.data.dto

import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType


abstract class ViewItemDto(
    val viewItemType: ViewItemType?
)