package com.example.fit_i.data.service

import com.example.fit_i.data.model.request.SignupValidatoinRequest
import com.example.fit_i.data.model.request.*
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.model.response.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface AccountsService {
    //이용약관수락
    @POST("api/accounts/terms")
    fun termsOk(@Body req : TermsOkRequest) : Call<BaseResponse>

    //고객 회원가입
    @POST("api/accounts/customer")
    fun signUpCustomer (@Body user : User) : Call<BaseResponse>

    //회원가입 validation
    @POST("api/accounts/customer/validation")
    fun signupCheckValidation( @Body req : SignupValidatoinRequest) : Call<BaseResponse>

    //로그인
    @POST("api/accounts/login")
    fun logIn(@Body loginRequest : LoginRequest) : Call<LoginResponse>

    //로그아웃
    @POST("api/accounts/logout")
    fun logOut(@Body token : LogoutRequest) : Call<BaseResponse>

    //비밀번호변경
    @PATCH("api/accounts/password")
    fun changePW(@Body req : ChangePWRequest) : Call<BaseResponse>

    //계정탈퇴
    @PATCH("api/accounts/close")
    fun close() : Call<BaseResponse>

    //계정 비밀번호 조회
    @GET("api/accounts/password/{email}")
    fun findPW(@Path("email") email: String) :Call<BaseResponse>

    //인증메일전송
    @GET("api/accounts/email/{email}")
    fun sendEmail(@Path("email") email : String) : Call<BaseResponse>
}