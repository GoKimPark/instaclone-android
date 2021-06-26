package com.gokimpark.instaclone.viewholder

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.gokimpark.instaclone.databinding.ViewPostBinding


class PostView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val binding = ViewPostBinding.inflate(LayoutInflater.from(context), this)

}