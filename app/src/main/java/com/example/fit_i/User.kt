package com.example.fit_i

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email : String,
    @SerializedName("password") val password : String,
    @SerializedName("profileImage") val profileImage: String
)
