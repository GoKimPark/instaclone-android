package com.gokimpark.instaclone.viewholder

import android.content.Context
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.gokimpark.instaclone.databinding.ViewProfileStatisticBinding


class ProfileStatisticView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val binding = ViewProfileStatisticBinding.inflate(LayoutInflater.from(context), this)


    fun setData(figure: String, description: String) {
        val spannableFigure = SpannableString(figure).apply {
            setSpan(
                RelativeSizeSpan(1.5F), 0, length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        with(binding.textView) {
            text = spannableFigure
            append("\n")
            append(description)
        }
    }

}