package com.gokimpark.instaclone.ui.common

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokimpark.instaclone.viewholder.createViewHolder
import com.gokimpark.instaclone.domain.model.viewitem.ViewItem
import com.gokimpark.instaclone.domain.model.viewitem.ViewItemType


class GeneralRecyclerViewAdapter : RecyclerView.Adapter<GeneralViewHolder>() {

    private var items = listOf<ViewItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder {
        return ViewItemType.values()[viewType].createViewHolder(parent)
    }


    override fun onBindViewHolder(holder: GeneralViewHolder, position: Int) {
        holder.bind(items[position])
    }


    override fun getItemCount(): Int {
        return items.size
    }


    override fun getItemViewType(position: Int): Int {
        return items[position].viewItemType.ordinal
    }

}