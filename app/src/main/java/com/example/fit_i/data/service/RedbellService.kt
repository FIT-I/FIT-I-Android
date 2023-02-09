package com.example.fit_i.data.service

import com.example.fit_i.data.model.request.ReportRequest
import com.example.fit_i.data.model.response.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RedbellService {
    //신고 API

    //신고 하기
    @POST("api/redbell")
    fun report(@Body req : ReportRequest) : Call<BaseResponse>

//    신고 사유 리스트 받아오기
//    GET
//    /api/redbell/reason
}