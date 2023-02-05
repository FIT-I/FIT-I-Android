package com.example.fit_i.ui.main.chat

import android.os.Message
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

//채팅방의 정보를 저장하는 ChatRoom 객체

@Parcelize
data class ChatRoom(
    val openChatLink : String,
    val trainerId : Int,
    val trainerName : String,
    val trainerGrade : Number,
    val trainerSchool : String,
    val customerId : Int,
    val pickUp : String,
    val customerLocation : String,
    val createdAt : String,
    val matchingId : Int,
    val trainerProfile : String

):Parcelable
