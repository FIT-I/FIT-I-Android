package com.example.fit_i.data.model.request.AlarmRequest

data class Review(
    val content: String,
    val createdDate: String,
    val customer: String,
    val grade: Int,
    val id: Int,
    val isDeleted: Int,
    val modifiedDate: String,
    val trainer: String
)