package com.example.fit_i.ui.main.chat

import android.os.Message
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

//채팅방의 정보를 저장하는 ChatRoom 객체

@Parcelize
data class ChatRoom(
    val profile : String,
    val name: String,
    val grade : Double,
    val school : String,
    val url : String,
    val day : String

):Parcelable
