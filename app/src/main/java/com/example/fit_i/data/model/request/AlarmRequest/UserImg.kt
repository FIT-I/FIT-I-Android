package com.example.fit_i.data.model.request.AlarmRequest

data class UserImg(
    val backGround: String,
    val etcImgList: List<EtcImg>,
    val id: Int,
    val profile: String,
    val trainer: String
)