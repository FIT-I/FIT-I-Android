package com.example.fit_i.ui.main.matching

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchingData(
//   val prof: String,
    val im : String,
    val star: String,
    val uni: String,
    val day : String
): Parcelable
