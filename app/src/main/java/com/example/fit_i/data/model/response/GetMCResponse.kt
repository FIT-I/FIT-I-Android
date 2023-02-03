package com.example.fit_i.data.model.response


data class GetMCResponse(
    var isSuccess : Boolean,
    var code : Int,
    var message : String,
    var result: List<Result> ) {

    data class Result(
        var matchingId: Int,
        var trainerId: Int,
        var name: String,
        var profile: String,
        var school: String,
        var grade: Number,
        var orderDate: String, //정확한 년도.월.일
        var orderDateGap: Int // 몇일전인지

    )
}