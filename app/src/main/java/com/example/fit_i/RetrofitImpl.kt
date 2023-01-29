package com.example.fit_i

import com.example.fit_i.data.service.AccountsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitImpl {
    private const val URL = "http://fiti.site/" // 예시 : "https://0.0.0.1:8080"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: AccountsService = retrofit.create(AccountsService::class.java)
    //서비스 따로따로 만들었는데...?
}