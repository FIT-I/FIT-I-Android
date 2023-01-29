package com.example.fit_i.data.model.response

data class GetTermsResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
){
    data class Result(
        val termDetail: String,
        val termIdx: Int,
        val termName: String
    )
}