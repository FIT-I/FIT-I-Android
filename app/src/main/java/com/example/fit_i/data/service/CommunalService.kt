package com.example.fit_i.data.service

import com.example.fit_i.data.model.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface CommunalService {
    //공용 API

    //매칭위치설정
    @PATCH("api/communal/location/{location}")
    fun setLocation(@Path("location") location:String):Call<BaseResponse>

    //트레이너 정보조회
    @GET("api/communal/trainer/{trainerIdx}")
    fun getTrainerInfo(@Path("trainerIdx") trainerIdx: Long) : Call<GetTrainerInfoResponse>

    //    이용약관조회 - 모든 약관을 하나의 문자열로 리턴, 마이페이지용(Response)
    @GET("api/communal/terms/all")
    fun getAllTerms() : Call<BaseResponse>

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