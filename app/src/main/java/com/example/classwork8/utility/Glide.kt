package com.example.classwork8.utility

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.classwork8.R

fun setImage(url: String, image: ImageView){
    Glide
        .with(image.context)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .centerCrop()
        .into(image)
}