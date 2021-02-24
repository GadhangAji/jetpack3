package com.d.jetpack1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var title: String,
    var img: Int,
    var overview: String
) : Parcelable