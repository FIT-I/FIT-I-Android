package com.example.fit_i.data.service

import com.example.fit_i.data.model.request.MatchingRequest
import com.example.fit_i.data.model.request.ReviewRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.model.response.GetTrainerListResponse
import com.example.fit_i.data.model.response.WishResponse
import retrofit2.Call
import retrofit2.http.*

interface CustomerService {

    //트레이너 찜하기
    @POST("api/customer/{trainerIdx}")
    fun addWish(@Path("trainerIdx") trainerIdx : Int) : Call<BaseResponse>

    //트레이너 찜하기 취소
    @DELETE("api/customer/{trainerIdx}")
    fun cancelWish(@Path("trainerIdx") trainerIdx : Int) : Call<BaseResponse>

    //리뷰작성
    @POST ("api/customer/review")
    fun writeReview(@Body req : ReviewRequest) : Call<BaseResponse>

    //트레이너 매칭요청
    @POST("api/customer/matching/{trainerIdx}")
    fun matcingPlz(@Body req : MatchingRequest, @Path("trainerIdx") trainerIdx: Int ) :Call<BaseResponse>

    //고객 프로필수정
    @PATCH("api/customer/profile/{profile}")
    fun modifyProfile(@Path("profile") profile: String) :Call<BaseResponse>

    //알림 on
    @PATCH("api/customer/notification/on")
    fun ringOn() :Call<BaseResponse>

    //알림 off
    @PATCH("api/customer/notification/off")
    fun ringOff(): Call<BaseResponse>

    //찜목록조회
    @GET("api/customer/wish")
    fun getWishlist() : Call<WishResponse>

    //트레이너 목록조회
    @GET("api/customer/trainer-list")
    fun getTrainerlist(@Query("category") category:String,
                       @Query("lastTrainerId") lastTrainerId: Int,
                       @Query("page") page: Int,
                       @Query("size") size: Int,
                       @Query("sort") sort: String
    )
    : Call<GetTrainerListResponse>

    @GET("api/customer/trainer-list")
    fun getTrainerlist(@Query("category") category:String,
                       @Query("page") page: Int,
                       @Query("size") size: Int,
                       @Query("sort") sort: Array<String>
    ): Call<GetTrainerListResponse>
}