package com.example.fit_i.data.model.request.AlarmRequest

data class UserImgX(
    val backGround: String,
    val etcImgList: List<EtcImgX>,
    val id: Int,
    val profile: String,
    val trainer: String
)