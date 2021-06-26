package com.gokimpark.instaclone.viewholder

import android.view.ViewGroup
import com.gokimpark.instaclone.data.model.viewitem.ViewItem
import com.gokimpark.instaclone.ui.common.GeneralViewHolder
import com.gokimpark.instaclone.ui.common.GeneralViewHolderFactory


object PersonCardViewHolderFactory : GeneralViewHolderFactory() {

    override fun createViewHolder(parent: ViewGroup): GeneralViewHolder = ViewHolder(PersonCardView(parent.context))

    private class ViewHolder(val itemView: PersonCardView) : GeneralViewHolder(itemView) {

        override fun bind(item: ViewItem) {
            itemView
        }

    }

}