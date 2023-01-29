package com.example.fit_i.data.service

import com.example.fit_i.data.model.request.MatchingRequest
import com.example.fit_i.data.model.request.ReviewRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.model.response.GetTrainerlistResponse
import com.example.fit_i.data.model.response.WishResponse
import retrofit2.Call
import retrofit2.http.*

interface CustomerService {

    //트레이너 찜하기
    @Headers("content-type: application/json")
    @POST("api/customer/{trainerIdx}")
    fun trainerSave(@Path("trainerIdx") trainerIdx : Int) : Call<BaseResponse>

    //트레이너 찜하기 취소
    @Headers("content-type: application/json")
    @DELETE("api/customer/{trainerIdx}")
    fun trainerSaveCancel(@Path("trainerIdx") trainerIdx : Int) : Call<BaseResponse>

    //리뷰작성
    @Headers("content-type: application/json")
    @POST ("api/customer/review")
    fun writeReview(@Body req : ReviewRequest) : Call<BaseResponse>

    //트레이너 매칭요청
    @Headers("content-type: application/json")
    @POST("api/customer/matching/{trainerIdx}")
    fun matcingPlz(@Body req : MatchingRequest, @Path("trainerIdx") trainerIdx: Int ) :Call<BaseResponse>


    //고객 프로필수정
    @Headers("content-type: application/json")
    @PATCH("api/customer/profile/{profile}")
    fun modifyProfile(@Path("profile") profile: String) :Call<BaseResponse>

    //알림 on
    @Headers("content-type: application/json")
    @PATCH("api/customer/notification/on")
    fun ringOn() :Call<BaseResponse>

    //알림 off
    @Headers("content-type: application/json")
    @PATCH("api/customer/notification/off")
    fun ringOff(): Call<BaseResponse>

    //매칭위치설정
    @PATCH("api/customer/location/{location}")
    fun setLocation(@Path("location") location:String):Call<BaseResponse>

    //찜목록조회
    @GET("api/customer/wish")
    fun getWishlist() : Call<WishResponse>

    //트레이너 목록조회
    @GET("api/customer/trainer-list")
    fun getTrainerlist(@Query("category") category:String, @Query("lastTrainerId") lastTrainerId : Int, @Query("pageable") pageable: Object) : Call<GetTrainerlistResponse>
}