package com.gokimpark.instaclone.domain.repository

import com.gokimpark.instaclone.domain.model.viewitem.ViewItem
import kotlinx.coroutines.flow.Flow

interface FeedRepository {

    fun getViewItems(): Flow<ViewItem>

}