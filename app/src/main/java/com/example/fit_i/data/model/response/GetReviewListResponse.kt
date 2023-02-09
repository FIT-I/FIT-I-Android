package com.example.fit_i.data.model.response

data class GetReviewListResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
){
    data class Result(
        val name: String,
        val profile: String? = null,
        val grade: Long,
        val createdAt: String,
        val contents: String
    )
}