package com.example.fit_i.data.model.response

import com.google.gson.annotations.SerializedName

data class WishResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
){
    data class Result(
        val createdAt: String,
        @SerializedName("star")
        val trainerGrade: Double,
        val trainerIdx: Int,
        @SerializedName("im")
        val trainerName: String,
        val trainerProfile: String,
        @SerializedName("uni")
        val trainerSchool: String
    )
}