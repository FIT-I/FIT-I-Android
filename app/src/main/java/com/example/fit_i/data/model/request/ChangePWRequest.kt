package com.example.fit_i.data.model.request

data class ChangePWRequest(
    val accessToken: String,
    val password: String,
    val refreshToken: String
)