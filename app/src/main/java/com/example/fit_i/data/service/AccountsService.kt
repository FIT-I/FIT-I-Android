package com.example.fit_i.data.service

import CloseResponse
import com.example.fit_i.Login
import com.example.fit_i.User
import com.example.fit_i.data.model.request.ChangePWRequest
import com.example.fit_i.data.model.request.UserToken
import com.example.fit_i.data.model.response.AccountBaseResponse
import com.example.fit_i.data.model.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface AccountsService {
    //고객 회원가입
    @Headers("content-type: application/json")
    @POST("api/accounts/customer")
    fun signUp (@Body user : User) : Call<AccountBaseResponse>

    //로그인
    @Headers("content-type: application/json")
    @POST("api/accounts/login")
    fun logIn(@Body login : Login) : Call<LoginResponse>

    //로그아웃
    @Headers("content-type: application/json")
    @POST("api/accounts/logout")
    fun logOut(@Body token : UserToken) : Call<AccountBaseResponse>

    //비밀번호변경
    @Headers("content-type: application/json")
    @PATCH("api/accounts/password")
    fun changePW(@Body req : ChangePWRequest) : Call<AccountBaseResponse>

    //계정탈퇴
    @Headers("content-type: application/json")
    @PATCH("api/accounts/close")
    fun close() : Call<CloseResponse>

    //계정 비밀번호 조회
    @Headers("content-type: application/json")
    @GET("api/accounts/password/{email}")
    fun findPW(@Path("email") email: String) :Call<AccountBaseResponse>

    //인증메일전송
    @Headers("content-type: application/json")
    @GET("api/accounts/email/{email}")
    fun sendEmail(@Path("email") email : String) : Call<AccountBaseResponse>


}