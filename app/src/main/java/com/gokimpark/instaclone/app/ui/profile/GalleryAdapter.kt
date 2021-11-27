package com.gokimpark.instaclone.app.ui.profile

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail

class GalleryAdapter : RecyclerView.Adapter<ThumbnailViewHolder>() {

    var data: List<Thumbnail> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        return ThumbnailViewHolder(ImageView(parent.context))
    }


    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        holder.bind(data[position])
    }


    override fun getItemCount(): Int {
        return data.size
    }

}