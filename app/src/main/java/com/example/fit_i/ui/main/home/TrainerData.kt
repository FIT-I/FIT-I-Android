package com.example.fit_i.ui.main.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrainerData(
    val id: Long,
    val name: String,
    val profile: String,
    val levelName: String,
    val school: String,
    val grade: Double,
    val certificateNum: Long,
    val contents: String,
    val cost: Long
): Parcelable