package com.gokimpark.instaclone.ui.common

import android.view.ViewGroup


abstract class GeneralViewHolderFactory {
    abstract fun createViewHolder(parent: ViewGroup): GeneralViewHolder
}