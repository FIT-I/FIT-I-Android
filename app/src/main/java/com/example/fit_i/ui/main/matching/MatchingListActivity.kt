package com.example.fit_i.ui.main.matching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.GetMatchlistResponse
import com.example.fit_i.data.service.MatchingService
import com.example.fit_i.databinding.ActivityMatchingListBinding
import com.example.fit_i.ui.profile.ProfileActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchingListActivity : AppCompatActivity() {
    //나중에 정의해도 됨 lateinit
    private lateinit var binding : ActivityMatchingListBinding

    fun onBind(data : GetMatchlistResponse.Result?){
        binding.tvMatchingPrice.text = data?.pricePerHour
        binding.tvMatchingAllprcie2.text = data?.totalPrice
        binding.tvMatchingStart.text = data?.matchingStart
        binding.tvMatchingEnd.text = data?.matchingEnd
        binding.tvMatchingAll.text = data?.matchingPeriod.toString()

        if(data?.pickUpType=="TRAINER_GO") {
            binding.tvMatchingPickup2.text = "트레이너님이 와주세요"
        }else if(data?.pickUpType=="CUSTOMER_GO") {
            binding.tvMatchingPickup2.text = "제가 직접 갈게요"
        }

        binding.tvMatchingPlace.text = data?.location
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchingListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val matchingId =intent.getLongExtra("matchingId",-1)//고객 인덱스
        val trainerId = intent.getLongExtra("trainerId",-1)//트레이너인덱스

        val btnmatching = findViewById<Button>(R.id.btn_matching_List)
        val matchingService = RetrofitImpl.getApiClient().create(MatchingService::class.java)

        // 트레이너 프로필로 이동하는 기능
        btnmatching.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)  // 인텐트를 생성해줌,
            intent.putExtra("trainerId",trainerId)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }

        matchingService.matchingList(matchingId).enqueue(object : Callback<GetMatchlistResponse>{
            override fun onResponse(
                call: Call<GetMatchlistResponse>,
                response: Response<GetMatchlistResponse>
            ) { if (response.isSuccessful){
                //정상 통신
                Log.d("post","매칭 명세표 onResponse 성공:"+ response.body().toString())
                val body = response.body()
                body?.let {
                    onBind(it.result)
                }
            }
                else{
                    //통신실패
                    Log.d("post","매칭 명세표 onResponse 실패:"+ response.body().toString())
                }
            }

            override fun onFailure(call: Call<GetMatchlistResponse>, t: Throwable) {
                //통신 실패 (예외)
                Log.d("post"," 매칭 명세표 onFailure 에러"+ t.message.toString())
            }
        })
    }
}
