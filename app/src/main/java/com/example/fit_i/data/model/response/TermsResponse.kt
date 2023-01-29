package com.example.fit_i.data.model.response

import com.example.fit_i.ResultX

data class TermsResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ResultX>
)