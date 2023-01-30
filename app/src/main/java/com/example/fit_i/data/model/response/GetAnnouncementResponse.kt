package com.example.fit_i.data.model.response

data class GetAnnouncementResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
){
    data class Result(
        val contents: String,
        val createdAt: String,
        val title: String
    )
}