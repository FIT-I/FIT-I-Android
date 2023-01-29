package com.example.fit_i.data.model.response

data class GetTrainerlistResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
){
    data class Result(
        val dto: List<Dto>,
        val hasNext: Boolean,
        val numberOfElements: Int
    ){
        data class Dto(
            val certificateNum: Int,
            val contents: String,
            val cost: Int,
            val grade: Double,
            val id: Int,
            val levelName: String,
            val name: String,
            val profile: String,
            val school: String
        )
    }
}