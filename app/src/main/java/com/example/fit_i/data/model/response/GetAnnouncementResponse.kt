package com.example.fit_i.data.model.response

import com.example.fit_i.ResultXXX

data class GetAnnouncementResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ResultXXX>
)