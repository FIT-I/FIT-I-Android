package com.example.fit_i.data.model.response

data class GetTrainerInfoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
){
    data class Result(
        val background: String,
        val cost: Int,
        val grade: Double,
        val imageList: String,
        val intro: String,
        val levelName: String,
        val name: String,
        val profile: String,
        val reviewDto: String,
        val school: String,
        val service: String
    )
}