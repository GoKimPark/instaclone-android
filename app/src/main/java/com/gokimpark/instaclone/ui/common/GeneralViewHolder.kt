package com.gokimpark.instaclone.ui.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gokimpark.instaclone.domain.model.viewitem.ViewItem


abstract class GeneralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: ViewItem)

}