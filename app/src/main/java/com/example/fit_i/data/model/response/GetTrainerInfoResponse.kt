package com.example.fit_i.data.model.response

data class GetTrainerInfoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
){
    data class Result(
        val name: String?,
        val profile: Any,
        val background: String,
        val levelName: String,
        val school: String,
        val grade: Double,
        val cost: Long,
        val intro: String?,
        val service: String?,
        val reviewDto: List<ReviewDto>?,
        val imageList: List<Any>?,
        //val category: String
    ){
        data class ReviewDto (
            val name: String,
            val profile: String? = null,
            val grade: Long,
            val createdAt: String,
            val contents: String
        )
    }
}