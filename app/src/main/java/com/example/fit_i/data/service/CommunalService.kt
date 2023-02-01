package com.example.fit_i.data.service

import com.example.fit_i.data.model.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CommunalService {
    //공용 API

    //트레이너 정보조회
    @GET("api/communal/trainer/{trainerIdx}")
    fun getTrainerInfo(@Path("trainerIdx") trainerIdx: Int) : Call<GetTrainerInfoResponse>

    //이용약관
    @GET("api/communal/terms")
    fun getTerms() : Call<GetTermsResponse>

    //리뷰 조회
    @GET("api/communal/review/{trainerIdx}")
    fun getReviewList(@Path("trainerIdx") trainerIdx : Int) : Call<GetReviewListResponse>

    //마이페이지 조회
    @GET("api/communal/mypage")
    fun getMypage() : Call<GetMypageResponse>

    //공지사항 목록 조회
    @GET("api/communal/announcement")
    fun getAnnouncement() : Call<GetAnnouncementResponse>
}