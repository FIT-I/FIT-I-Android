package com.example.fit_i.data.service

import com.example.fit_i.data.model.response.GetMatchingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH

interface MatchingService {

    //고객의 매칭목록 조회
    @GET("api/matching/customer")
    fun getCustomerMatching() : Call<GetMatchingResponse>

    //트레이너의 매칭목록 조회
//    @Headers("content-type: application/json")
//    @GET("api/matching/trainer")
//    fun getTrainerMatching(): Call<GetTMatchingResponse>
//
//    //매칭정보조회
//    @Headers("content-type: application/json")
//    @GET("api/matching/{matchingIdx}/accept")
//    fun getMatching(): Call<GetMatchResponse>
//
//    //매칭수락
//    @Headers("content-type: application/json")
//    @PATCH("api/matching/{matchingIdx}/accept")
//    fun getAcceptMatching(): Call<GetAcceptResponse>
//    //매칭 거절
//    @Headers("content-type: application/json")
//    @PATCH("api/matching/{matchingIdx}/reject")
//    fun getRejectMatching(): Call<GetRejectResponse>


}