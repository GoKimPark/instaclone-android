package com.gokimpark.instaclone.app.viewholder

import android.view.ViewGroup
import com.gokimpark.instaclone.domain.model.viewitem.ViewItem
import com.gokimpark.instaclone.app.ui.common.GeneralViewHolder
import com.gokimpark.instaclone.app.ui.common.GeneralViewHolderFactory


object PersonCardViewHolderFactory : GeneralViewHolderFactory() {

    override fun createViewHolder(parent: ViewGroup): GeneralViewHolder = ViewHolder(PersonCardView(parent.context))

    private class ViewHolder(val itemView: PersonCardView) : GeneralViewHolder(itemView) {

        override fun bind(item: ViewItem) {
            itemView
        }

    }

}