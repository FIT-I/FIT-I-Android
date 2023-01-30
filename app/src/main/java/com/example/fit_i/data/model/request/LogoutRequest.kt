package com.example.fit_i.data.model.request

data class LogoutRequest(
    val accessToken: String,
    val refreshToken: String
)