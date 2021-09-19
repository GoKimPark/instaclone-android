package com.gokimpark.instaclone.data.mapper

import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType


fun String?.toViewItemTypeEnum() = runCatching { ViewItemType.valueOf(this!!) }.getOrDefault(ViewItemType.UNKNOWN)