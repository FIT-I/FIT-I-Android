package com.example.fit_i.ui.main.matching

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchingData(
    val matchingId: Int,
    val trainerId: Int,
    val name: String,
    val profile: String,
    val school: String,
    val grade: Number,
    val orderDate: String,
    val orderDateGap: Int
): Parcelable
