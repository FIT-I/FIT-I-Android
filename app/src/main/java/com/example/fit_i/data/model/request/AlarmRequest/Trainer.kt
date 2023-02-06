package com.example.fit_i.data.model.request.AlarmRequest

data class Trainer(
    val category: String,
    val grade: Int,
    val id: Int,
    val intro: String,
    val level: Level,
    val major: String,
    val matchingOrderList: List<MatchingOrder>,
    val priceHour: Int,
    val redBellList: List<RedBellX>,
    val reviewList: List<ReviewX>,
    val school: String,
    val service: String,
    val trainerCertList: List<TrainerCert>,
    val user: String,
    val userImg: UserImg
)