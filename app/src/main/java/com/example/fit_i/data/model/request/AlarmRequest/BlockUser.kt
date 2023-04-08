package com.example.fit_i.data.model.request.AlarmRequest

data class BlockUser(
    val createdAt: String,
    val id: Int,
    val `receiver`: String,
    val sender: String
)