package com.sobhan.sabaideatask.utils



import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView,url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .centerCrop()
        .into(imageView)


}



















