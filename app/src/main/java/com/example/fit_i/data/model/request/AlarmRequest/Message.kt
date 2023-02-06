package com.example.fit_i.data.model.request.AlarmRequest

data class Message(
    val chatRoom: ChatRoom,
    val createdAt: String,
    val `data`: String,
    val id: Int,
    val sender: Sender
)