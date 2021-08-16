package com.gokimpark.instaclone.data.mapper

import com.gokimpark.instaclone.data.model.viewitem.ViewItemType


fun String?.toViewItemTypeEnum() = runCatching { ViewItemType.valueOf(this!!) }.getOrDefault(ViewItemType.UNKNOWN)