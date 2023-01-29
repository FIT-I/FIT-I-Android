package com.example.fit_i.data.model.response

import com.example.fit_i.ResultXX

data class GetMypageResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ResultXX
)