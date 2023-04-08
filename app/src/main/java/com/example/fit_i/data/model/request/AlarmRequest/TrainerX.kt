package com.example.fit_i.data.model.request.AlarmRequest

data class TrainerX(
    val category: String,
    val grade: Int,
    val id: Int,
    val intro: String,
    val level: LevelX,
    val major: String,
    val matchingOrderList: List<MatchingOrder>,
    val priceHour: Int,
    val redBellList: List<RedBellXX>,
    val reviewList: List<ReviewXX>,
    val school: String,
    val service: String,
    val trainerCertList: List<TrainerCertX>,
    val user: String,
    val userImg: UserImgX
)