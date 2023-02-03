package com.example.fit_i.data.model.request

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String,
    @SerializedName("profileImage") val profileImage: String
)
