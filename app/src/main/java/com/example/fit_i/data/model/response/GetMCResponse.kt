package com.example.fit_i.data.model.response


data class GetMCResponse(
    val isSuccess : Boolean,
    val code : Int,
    val message : String,
    val result: List<Result> ) {

    data class Result(
        val matchingId: Long,
        val trainerId: Long,
        val name: String,
        val profile: String,
        val school: String,
        val grade: Number,
        val orderDate: String, //정확한 년도.월.일
        val orderDateGap: Int // 몇일전인지
    )
}