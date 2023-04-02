package com.example.fit_i.data.model.response

data class GetMatchingResponse(
    val isSuccess: Boolean,
    val code: Int,
    val message: String,
    val result: List<Result>
){
    data class Result(
        val matchingId: Long,
        val name: String,
        val profile: String,
        val school: String,
        val grade: Number,
        val orderDate: String,
        val orderDateGap: Int
    )
}
