package com.cuursoft.filmsubmittwo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvMovie(
    var judul2: String?,
    var deskripsi2: String?,
    var foto2: String?,
    var skor2: String?,
    var rilis2: String?

) : Parcelable