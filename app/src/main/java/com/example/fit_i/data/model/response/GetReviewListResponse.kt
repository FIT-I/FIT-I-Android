package com.example.fit_i.data.model.response

data class GetReviewListResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<String>
)