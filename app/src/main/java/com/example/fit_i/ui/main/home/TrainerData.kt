package com.example.fit_i.ui.main.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrainerData(
//    val id: Long,
    val name: String,
//    val profile: Int,
//    val levelName: String,
    val school: String,
//    val grade: Int,
//    val certificateNum: Long,
    val contents: String,
    val cost: String,
    val review: String,
    val km: String
): Parcelable