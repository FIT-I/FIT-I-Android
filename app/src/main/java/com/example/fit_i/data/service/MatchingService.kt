package com.example.fit_i.data.service

import com.example.fit_i.data.model.response.GetMCResponse
import com.example.fit_i.data.model.response.GetMatchlistResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchingService {

    //고객 매칭목록조회
    @GET("api/matching/customer")
    fun matchingCustomer() : Call<GetMCResponse>

    //매칭정보
    @GET("api/matching/{matchingIdx}")
    fun matchingList(@Path("matchingIdx") matchingIdx: Long) : Call<GetMatchlistResponse>
}