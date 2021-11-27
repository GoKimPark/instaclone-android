package com.gokimpark.instaclone.app.ui.profile

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.gokimpark.instaclone.app.utility.loadInCircle
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.databinding.ViewProfileBinding
import com.gokimpark.instaclone.domain.model.viewitem.Thumbnail

class ProfileView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val adapter = GalleryAdapter()

    private val binding = ViewProfileBinding.inflate(LayoutInflater.from(context), this).apply {
        gallery.adapter = adapter
    }


    fun setData(profile: Profile) {
        with(binding.header) {
            postCount.setData(profile.postCount, "Posts")
            followerCount.setData(profile.followerCount, "Followers")
            followingCount.setData(profile.followingCount, "Following")
            avatar.loadInCircle(profile.user.avatarUrl)
        }
    }

    fun setGallery(thumbnails: List<Thumbnail>) {
        adapter.data = thumbnails
    }

}