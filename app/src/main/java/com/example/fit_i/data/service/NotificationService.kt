package com.example.fit_i.data.service

import com.example.fit_i.data.model.request.FirebaseTokenRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface NotificationService {

    //파이어베이스 api 토큰 저장
    @POST("api/firebase")
    fun gettoken(@Body req : FirebaseTokenRequest) : Call<String>

    //파이어베이스 api 토큰 삭제
    @DELETE("api/firebase/users/{email}")
    fun deletetoken(@Path("email") email: String) : Call<String>


}