package com.example.fit_i.ui.main.mypage.notice

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NoticeData(
    val title: String,
    val contents : String,
    val createdAt : String
): Parcelable
