package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.data.service.CustomerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity :AppCompatActivity() {
    private var trainerIdx: Int = 0

    lateinit var heartBtn: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        trainerIdx = 1 // intent getint로 실제 클릭한 트레이너값 받아와야함

        heartBtn = findViewById<Button>(R.id.heart_btn) as CheckBox
        heartBtn.setOnClickListener { onCheckChanged(heartBtn) }

        val matchRequest = findViewById<Button>(R.id.match_request_btn)
        fun moveToNextPage() {
            val intent = Intent(this, MatchServiceActivity::class.java)
            startActivity(intent)
        }
        matchRequest.setOnClickListener {
            moveToNextPage()
        }

        val moreAboutMe = findViewById<ImageButton>(R.id.btn_about_me)
        fun showAboutMe() {
            val intent = Intent(this, ProfileAboutMeActivity::class.java)
            startActivity(intent)
        }
        moreAboutMe.setOnClickListener {
            showAboutMe()
        }

        val moreAboutService = findViewById<ImageButton>(R.id.btn_about_service)
        fun showAboutService() {
            val intent = Intent(this, ProfileAboutServiceActivity::class.java)
            startActivity(intent)
        }
        moreAboutService.setOnClickListener {
            showAboutService()
        }
    }


    val service = RetrofitImpl.getApiClient().create(CustomerService::class.java)

    private fun onCheckChanged(compoundButton: CompoundButton) {
        if (heartBtn.isChecked) {
            service.trainerSave(trainerIdx).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    if (response.isSuccessful) {
                        // 정상적으로 통신이 성공된 경우
                        //val result: User? = response.body()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        //Log.d("post","result: "+response.)
                        //Log.d("post", "onResponse 성공: " + result.toString());
                    } else {
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패")
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            })
        } else
            service.trainerSaveCancel(trainerIdx).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    if (response.isSuccessful) {
                        // 정상적으로 통신이 성공된 경우
                        //val result: User? = response.body()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        //Log.d("post","result: "+response.)
                        //Log.d("post", "onResponse 성공: " + result.toString());
                    } else {
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패")
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            })
    }

}