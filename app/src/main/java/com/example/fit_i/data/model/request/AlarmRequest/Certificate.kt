package com.example.fit_i.data.model.request.AlarmRequest

data class Certificate(
    val id: Int,
    val name: String,
    val trainerCertList: List<String>
)