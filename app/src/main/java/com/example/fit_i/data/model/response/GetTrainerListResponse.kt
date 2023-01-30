package com.example.fit_i.data.model.response

data class GetTrainerListResponse(
    val isSuccess: Boolean,
    val code: Long,
    val message: String,
    val result: Result
){
    data class Result (
        val numberOfElements: Long,
        val hasNext: Boolean,
        val dto: List<Dto>
    ){
        data class Dto (
            val id: Long,
            val name: String,
            val profile: String,
            val levelName: String,
            val school: String,
            val grade: Double,
            val certificateNum: Long,
            val contents: String,
            val cost: Long
        )
    }
}