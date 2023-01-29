package com.example.fit_i

import java.io.Serializable
//채팅방에서 오간 메시지를 저장하는 객체
data class Message(
   val name: String,
   val date: String,
   val content: String,
   //val pic : String
)
