package com.gokimpark.instaclone.app.viewholder

import android.view.ViewGroup
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType.*
import com.gokimpark.instaclone.app.ui.common.GeneralViewHolder


fun ViewItemType.createViewHolder(parent: ViewGroup): GeneralViewHolder = when (this) {
    UNKNOWN -> FallbackViewHolderFactory
    POST -> PostViewHolderFactory
    CAROUSEL -> FallbackViewHolderFactory
    PERSON_CARD -> PersonCardViewHolderFactory
}.createViewHolder(parent)