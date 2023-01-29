package com.example.fit_i.data.model.request

data class ReviewRequest (
    val trainerIdx : Int,
    val grade : Int,
    val contents : String
)