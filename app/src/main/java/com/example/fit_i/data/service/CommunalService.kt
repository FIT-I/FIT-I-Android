package com.example.fit_i.data.service

import GetReviewResponse
import com.example.fit_i.data.model.response.GetAnnouncementResponse
import com.example.fit_i.data.model.response.GetMypageResponse
import com.example.fit_i.data.model.response.TermsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CommunalService {
    //트레이너 정보조회
    //@GET("/api/communal/trainer/{trainerIdx}")
    //fun getTrainerInfo(trainerIdx: Int) : Call<>

    //이용약관
    @GET("/api/communal/terms")
    fun checkTerms() : Call<TermsResponse>

    //리뷰 조회
    @GET("/api/communal/review/{trainerIdx}")
    fun getReview(@Path("trainerIdx") trainerIdx : Int) : Call<GetReviewResponse>

    //마이페이지 조회
    @GET("/api/communal/mypage")
    fun getMypage() : Call<GetMypageResponse>

    //공지사항 목록 조회
    @GET("/api/communal/announcement")
    fun getAnnouncemet() : Call<GetAnnouncementResponse>



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