package com.example.fit_i.data.model.request.AlarmRequest

data class RedBell(
    val createdDate: String,
    val customer: String,
    val id: Int,
    val modifiedDate: String,
    val reason: String,
    val trainer: String
)