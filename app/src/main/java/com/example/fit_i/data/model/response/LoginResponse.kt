package com.example.fit_i.data.model.response

import com.example.fit_i.data.model.request.UserToken

data class LoginResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: UserToken
)