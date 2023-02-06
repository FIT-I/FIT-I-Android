package com.example.fit_i.data.model.request.AlarmRequest

data class MatchingOrder(
    val createdDate: String,
    val customer: String,
    val finishAt: String,
    val id: Int,
    val isComplete: String,
    val modifiedDate: String,
    val openChatLink: String,
    val pickUpType: String,
    val startAt: String,
    val trainer: String
)