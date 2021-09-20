package com.gokimpark.instaclone.app.ui.profile

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gokimpark.instaclone.R

class ImageViewHolder(val itemView: ImageView) : RecyclerView.ViewHolder(itemView) {

    fun bind(url: String) {
        itemView.setBackgroundResource(R.drawable.ic_launcher_foreground)
    }

}