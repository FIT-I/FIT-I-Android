package com.example.fit_i.data.model.request

data class ReviewRequest(
    val trainerIdx: Long,
    val grade: Int,
    val contents: String
)