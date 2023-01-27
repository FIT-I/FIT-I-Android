package com.example.fit_i

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    //고객 회원가입
    @Headers("content-type: application/json")
    @POST("api/accounts/customer")
    fun Signup (@Body user : User) : Call<User>

    //로그인
    @Headers("content-type: application/json")
    @POST("api/accounts/login")
    fun Login(@Body login : Login) : Call<Login>

    //

    //트레이너 정보조회
    //@GET("/api/communal/trainer/{trainerIdx}")
    //fun getTrainer(@Path("trainerIdx") trainerIdx: Int): Call<TrainerResponse>


    //fun postUserInfo(@Path("id") id:String, @Body userInfo : UserInfo) : Call<UserInfo>
//
//    @GET("users/{id}")
//    fun getUserInfo(@Path("id") id : String) : Call<Login>
//
//    //GET 예제
//    @GET("posts/1")
//    fun getUser(): Call<User>
//
//    @GET("posts/{page}")
//    fun getUserPage(@Path("page") page: String): Call<User>


}