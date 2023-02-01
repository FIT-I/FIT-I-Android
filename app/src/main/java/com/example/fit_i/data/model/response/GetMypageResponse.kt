package com.example.fit_i.data.model.response

import com.google.gson.annotations.SerializedName

data class GetMypageResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
){
    data class Result(
        @SerializedName("email") val email: String,
        @SerializedName("location") val location: String,
        @SerializedName("profile") val profile: String,
        @SerializedName("userIdx") val userIdx: Int,
        @SerializedName("userName") val userName: String
    )
}