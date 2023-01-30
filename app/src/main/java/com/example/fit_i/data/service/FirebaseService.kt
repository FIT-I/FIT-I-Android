package com.example.fit_i.data.service

import com.example.fit_i.data.model.request.SaveTokenRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface FirebaseService {
    //토큰 저장
    @POST("api/firebase")
    fun saveToken(@Body req : SaveTokenRequest) : Call<String>

    //토큰 삭제
    @DELETE("api/firebase/users/{email}")
    fun deleteToken(@Path("email") email:String) : Call<String>

}