@file:Suppress("DEPRECATION")

package com.d.jetpack1.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.d.jetpack1.data.MovieEntity
import com.d.jetpack1.data.detail.DetailActivity

val MOVIE_ID = "MOVIE_ID"

infix fun Context.requestOption(radius: Int): RequestOptions {
    return RequestOptions().transforms(CenterCrop(), RoundedCorners(radius))
}

infix fun Activity.DetailMovie(model: MovieEntity): Intent {
    return Intent(this, DetailActivity::class.java).apply {
        putExtra(MOVIE_ID, model)
    }
}