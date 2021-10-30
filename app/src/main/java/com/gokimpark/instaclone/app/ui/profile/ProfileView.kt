package com.gokimpark.instaclone.app.ui.profile

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.bumptech.glide.Glide
import com.gokimpark.instaclone.R
import com.gokimpark.instaclone.domain.model.viewitem.Profile
import com.gokimpark.instaclone.databinding.ViewProfileBinding

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
            Glide.with(context)
                .load(profile.user.avatarUrl)
                .circleCrop()
                .into(avatar)
        }

        adapter.data = List(11) { "" }
    }

}