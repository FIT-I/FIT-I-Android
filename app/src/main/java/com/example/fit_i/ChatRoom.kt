package com.example.fit_i

import android.os.Message
import java.io.Serializable

//채팅방의 정보를 저장하는 ChatRoom 객체
data class ChatRoom(
    val usrs: Map<String,Boolean>? = HashMap(), // 채팅방에 포함된 사용자
    val messages: Map<String,Message>? = HashMap() //해당 채팅방에서 오간 메시지


): Serializable {

}
