package com.example.fit_i

import com.google.firebase.firestore.auth.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {

    //GET 예제
//
//    //회원가입
//    @POST("api/accounts")
//    fun signUp (@Body req : SignInDto) : Call<SignUpInResponse>
//

    //GET 예제
    @GET("posts/1")
    fun getUser(): Call<User>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page: String): Call<User>

    //찜목록조회
//    @GET("api/customer/wish")
//    fun getCustomerWish(@Path())
}