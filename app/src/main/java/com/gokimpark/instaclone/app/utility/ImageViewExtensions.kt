package com.gokimpark.instaclone.app.utility

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gokimpark.instaclone.R


fun ImageView.loadThumbnail(url: String) {
    adjustViewBounds = true
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_launcher_foreground)
        .centerCrop()
        .into(this)
}


fun ImageView.loadInCircle(url: String) {
    Glide.with(this)
        .load(url)
        .circleCrop()
        .into(this)
}