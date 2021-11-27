package com.gokimpark.instaclone.app.ui.profile

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.gokimpark.instaclone.R
import com.gokimpark.instaclone.app.utility.loadThumbnail
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail

class ThumbnailViewHolder(val view: ImageView) : RecyclerView.ViewHolder(view) {

    init {
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun bind(thumbnail: Thumbnail) {
        view.loadThumbnail(thumbnail.imageUrl)
    }

}