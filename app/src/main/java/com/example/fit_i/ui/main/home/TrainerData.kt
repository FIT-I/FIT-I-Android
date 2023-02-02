package com.example.fit_i.ui.main.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrainerData(
    val name: String,
    val category: String,
    val rating: Double,
    val univ: String,
    val pr: String,
    val money: Int,
): Parcelable