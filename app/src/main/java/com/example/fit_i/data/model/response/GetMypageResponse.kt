package com.example.fit_i.data.model.response

data class GetMypageResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
){
    data class Result(
        val email: String,
        val location: String,
        val profile: String,
        val userIdx: Int,
        val userName: String
    )
}