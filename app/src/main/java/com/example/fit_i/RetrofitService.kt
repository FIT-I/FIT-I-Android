package com.example.fit_i

import com.google.gson.annotations.SerializedName
import com.kakao.sdk.user.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
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

    //리뷰 작성
    //(url)을 넣기
    //fun 만들고 싶은 기능 작성하기
    @POST("/api/customer/review")
    fun UserReview(@Body reviw: Review): Call<ReviewResponse>
}