package com.example.fit_i.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.ui.match.MatchServiceActivity
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.model.response.GetTrainerInfoResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.ActivityProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity :AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private var trainerIdx: Int =252

    private lateinit var wish: CheckBox

    fun onBind(data: GetTrainerInfoResponse.Result){
        //binding.ivTrainerProfile.setImageResource(data.result.profile)
        //binding.iv_background_photo=data.result.background

        binding.tvTrainerName.text=data.name
        //binding.ivTrainerGrade.text=data.result.levelName

        //binding.tvDistance.text=data.result
        binding.tvTrainerStar.text= data.grade.toString()
        binding.tvUniversityInfo.text=data.school

        binding.tvManagePrice.text= data.cost.toString()
        binding.tvAboutMe.text=data.intro
        binding.tvAboutService.text=data.service

        binding.tvAverageValue.text= data.grade.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        binding = ActivityProfileBinding.inflate(layoutInflater)


        //trainerIdx = 2// intent getint로 실제 클릭한 트레이너값 받아와야함


        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getTrainerInfo(trainerIdx).enqueue(object : Callback<GetTrainerInfoResponse> {
            override fun onResponse(call: Call<GetTrainerInfoResponse>, response: Response<GetTrainerInfoResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    onBind(response.body()!!.result)
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()

                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetTrainerInfoResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })


        wish = findViewById<Button>(R.id.cb_heart_btn) as CheckBox
        wish.setOnClickListener { onCheckChanged(wish) }

        val matchRequest =findViewById<Button>(R.id.btn_match_request)
        fun moveToNextPage(){
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
        if (wish.isChecked) {
            service.addWish(trainerIdx).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) { if (response.isSuccessful) {
                        // 정상적으로 통신이 성공된 경우
                        //val result: User? = response.body()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        Toast.makeText(this@ProfileActivity, "찜 목록에 추가", Toast.LENGTH_SHORT).show()
                        //Log.d("post","result: "+response.)
                        //Log.d("post", "onResponse 성공: " + result.toString());
                    } else {
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패 "+ response.body().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            })
        } else
            service.cancelWish(trainerIdx).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) { if (response.isSuccessful) { // response의 status code가 200~299 사이의
                    // 정상적으로 통신이 성공된 경우
                        //val result: User? = response.body()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        Toast.makeText(this@ProfileActivity, "찜 목록에서 제거", Toast.LENGTH_SHORT).show()
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