package com.example.fit_i.data.model.request

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignupValidationRequest(
    val email: String,
    val name: String,
    val password: String
) :Parcelable