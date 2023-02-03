package com.example.fit_i.data.service

import com.example.fit_i.data.model.response.GetMCResponse
import retrofit2.Call
import retrofit2.http.GET

interface MatchingService {
    @GET("api/matching/customer")
    fun matchingcustomer() : Call<GetMCResponse>
}