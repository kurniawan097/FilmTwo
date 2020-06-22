package com.cuursoft.filmsubmittwo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var judul: String?,
    var deskripsi: String?,
    var foto: String?,
    var skor: String?,
    var rilis: String?
) : Parcelable