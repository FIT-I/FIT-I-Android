package com.example.fit_i.ui.profile.review

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fit_i.*
import com.example.fit_i.data.model.response.GetReviewListResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.databinding.ActivityProfileReviewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileReviewActivity:AppCompatActivity() {
    private lateinit var binding: ActivityProfileReviewBinding
    private val trainerIdx =intent.getLongExtra("reviewIdx",-1)

    //private val trainerIdx : Long = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val rvReview : RecyclerView = findViewById(R.id.rv_review)

        val reviewList : ArrayList<Review> = arrayListOf()

        lodeData()

/*
        reviewList.apply {
            add(Review("박윤빈 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(Review("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(Review("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
            add(Review("박윤빈 ","2022.01.11",4.5,"친절한 지도 감사합니다:)"))
            add(Review("노규리 ","2022.01.11",4.5,"좋았어요. 친절하고 잘 가르쳐줬습니다~~~"))
            add(Review("김소연 ","2022.01.11",4.5,"Pt가 처음이라 두려웠지만, 쉽게 접할 수 있어서 좋았습니다."))
        }*/

    }
    private fun setAdapter(result: List<GetReviewListResponse.Result>) {
        val previewAdapter = PReviewAdapter(result)
        binding.rvReview.adapter=previewAdapter

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager=linearLayoutManager
        binding.rvReview.setHasFixedSize(true)

    }

    private fun lodeData() {
        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getReviewList(trainerIdx).enqueue(object :
            Callback<GetReviewListResponse> {
            override fun onResponse(call: Call<GetReviewListResponse>, response: Response<GetReviewListResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    //onBind(response.body()!!.result)
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    //Toast.makeText(this@ProfileActivity, "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()

                    val body = response.body()
                    body?.let {
                        setAdapter(it.result)
                    }
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<GetReviewListResponse>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })
    }



}