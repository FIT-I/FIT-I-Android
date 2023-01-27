package com.example.fit_i

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)
