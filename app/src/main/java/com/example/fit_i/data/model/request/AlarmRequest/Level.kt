package com.example.fit_i.data.model.request.AlarmRequest

data class Level(
    val id: Int,
    val name: String,
    val trainers: List<String>
)