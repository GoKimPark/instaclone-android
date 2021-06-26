package com.gokimpark.instaclone.viewholder

import android.view.ViewGroup
import com.gokimpark.instaclone.data.model.viewitem.ViewItemType
import com.gokimpark.instaclone.data.model.viewitem.ViewItemType.*
import com.gokimpark.instaclone.ui.common.GeneralViewHolder


fun ViewItemType.createViewHolder(parent: ViewGroup): GeneralViewHolder = when (this) {
    UNKNOWN -> FallbackViewHolderFactory
    POST -> PostViewHolderFactory
    THUMBNAIL -> FallbackViewHolderFactory
    CAROUSEL -> FallbackViewHolderFactory
    PERSON_CARD -> PersonCardViewHolderFactory
}.createViewHolder(parent)