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
    private var _binding: ActivityMatchingListBinding? = null
    private val binding : ActivityMatchingListBinding
    get() = requireNotNull(_binding){"ActivityMatchingListBinding"}

    private var matchingIdx : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matching_list)
        _binding = ActivityMatchingListBinding.inflate(layoutInflater)

        val btnmatching = findViewById<Button>(R.id.btn_matching_List)
        val btnback = findViewById<ImageButton>(R.id.btn_back)
        val matchingService = RetrofitImpl.getApiClient().create(MatchingService::class.java)


        //뒤로 가기 버튼
        btnback.setOnClickListener {
            val matchingFragment = MatchingFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container,matchingFragment).commit()
        }

        // 트레이너 프로필로 이동하는 기능
        btnmatching.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }


        matchingService.matchinglist(matchingIdx).enqueue(object : Callback<GetMatchlistResponse>{
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

    fun onBind(data : GetMatchlistResponse.Result){
        binding.tvMatchingPrice.text = data.pricePerHour
        binding.tvMatchingAllprcie2.text = data.totalPrice
        binding.tvMatchingStart.text = data.matchingStart
        binding.tvMatchingEnd.text = data.matchingEnd
        binding.tvMatchingAlldate.text = data.matchingPeriod.toString()
        binding.tvMatchingPickup2.text = data.pickUpType
        binding.tvMatchingPlace.text = data.location
    }


}
