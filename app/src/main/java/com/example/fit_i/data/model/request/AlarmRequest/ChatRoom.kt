package com.example.fit_i.data.model.request.AlarmRequest

data class ChatRoom(
    val chatUser: List<ChatUser>,
    val createdAt: String,
    val id: Int,
    val messages: List<String>,
    val roomName: String
)