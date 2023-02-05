package com.example.fit_i.data.service

import com.example.fit_i.data.model.response.GetChatResponse
import retrofit2.Call
import retrofit2.http.GET

interface ChatService {
    @GET("api/chat/entered")
    fun chatcustomer() : Call<GetChatResponse>


}