package com.example.fit_i.data.model.response

data class LoginResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: UserToken
){
    data class UserToken(
        val accessToken: String,
        val refreshToken: String
    )
}