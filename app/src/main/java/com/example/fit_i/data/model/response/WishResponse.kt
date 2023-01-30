package com.example.fit_i.data.model.response

data class WishResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
){
    data class Result(
        val createdAt: String,
        val trainerGrade: Double,
        val trainerIdx: Int,
        val trainerName: String,
        val trainerProfile: String,
        val trainerSchool: String
    )
}