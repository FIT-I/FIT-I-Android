package com.example.fit_i.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.model.response.GetTrainerInfoResponse
import com.example.fit_i.data.model.response.WishResponse
import com.example.fit_i.data.service.CommunalService
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.ActivityProfileBinding
import com.example.fit_i.ui.main.home.HomeFragment
import com.example.fit_i.ui.match.MatchServiceActivity
import com.example.fit_i.ui.profile.review.ProfileReviewActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates


class ProfileActivity :AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    var id by Delegates.notNull<Long>()
    var service by Delegates.notNull<String>()
    var me by Delegates.notNull<String>()


    private lateinit var wish: CheckBox

    fun onBind(data: GetTrainerInfoResponse.Result?){

        if (data?.profile == "trainerProfile"){
            binding.ivTrainerProfile.setImageResource(R.drawable.ic_profile)
        }
        else if (data?.profile != "trainerProfile"|| data.profile != null) {
            Glide.with(this)
                .load("${data?.profile}")
                .into(binding.ivTrainerProfile)
            binding.ivTrainerProfile.clipToOutline = true
            Log.d("post", data?.profile.toString())
        }

        if (data?.background != null) {
            Glide.with(this)
                .load("${data.background}")
                .into(binding.ivBackgroundPhoto)
        }

        binding.tvTrainerName.text=data?.name
        //binding.ivTrainerGrade.text=data.result.levelName

        //binding.tvDistance.text=data.result
        binding.tvTrainerStar.text= data?.grade.toString()
        binding.tvUniversityInfo.text=data?.school

        binding.tvManagePrice.text= data?.cost.toString()
        binding.tvAboutMe.text=data?.intro
        binding.tvAboutService.text=data?.service

        service = data?.service.toString()
        me = data?.intro.toString()

        binding.tvAverageValue.text= data?.grade.toString()
        binding.tvReviewNum.text=data?.reviewDto?.size.toString()

        //리뷰 바인딩
        if(data?.reviewDto?.size!! >1) {
            binding.tvReview1Name.text = data?.reviewDto?.get(0)?.name
            binding.tvReview1Content.text = data?.reviewDto?.get(0)?.contents
            binding.tvReview1Date.text = data?.reviewDto?.get(0)?.createdAt
            binding.tvReivew1Star.text = data?.reviewDto?.get(0)?.grade.toString()

            binding.tvReview2Name.text = data?.reviewDto?.get(1)?.name
            binding.tvReview2Content.text = data?.reviewDto?.get(1)?.contents
            binding.tvReview2Date.text = data?.reviewDto?.get(1)?.createdAt
            binding.tvReivew2Star.text = data?.reviewDto?.get(1)?.grade.toString()
        }
        else if(data?.reviewDto?.size==1){
            binding.tvReview1Name.text = data?.reviewDto?.get(0)?.name
            binding.tvReview1Content.text = data?.reviewDto?.get(0)?.contents
            binding.tvReview1Date.text = data?.reviewDto?.get(0)?.createdAt
            binding.tvReivew1Star.text = data?.reviewDto?.get(0)?.grade.toString()

            binding.tvReview2Name.text = ""
            binding.tvReview2Content.text = ""
            binding.tvReview2Date.text = ""
            binding.tvReivew2Star.text =""
            binding.ivReview2Star.visibility= View.INVISIBLE
        }
        else{
            binding.tvReview1Name.text = ""
            binding.tvReview1Content.text = ""
            binding.tvReview1Date.text = ""
            binding.tvReivew1Star.text = ""
            binding.ivReview1Star.visibility= View.INVISIBLE

            binding.tvReview2Name.text = ""
            binding.tvReview2Content.text = ""
            binding.tvReview2Date.text = ""
            binding.tvReivew2Star.text =""
            binding.ivReview2Star.visibility= View.INVISIBLE
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(intent.hasExtra("trainerIdx")) {
            id = intent.getLongExtra("trainerIdx", -1)
        }
        else if(intent.hasExtra("trainerId")){
            id = intent.getLongExtra("trainerId", -1)
        }
        else if(intent.hasExtra("chatTrainerId")){
            id = intent.getLongExtra("chatTrainerId", -1)
        }
        else{
            id = intent.getLongExtra("likeTrainerIdx",-1)
        }

        Log.d("post", id.toString())

        customerService.getWishlist().enqueue(object: Callback<WishResponse>{
            override fun onResponse(
                call : Call<WishResponse>,
                response: Response<WishResponse>
            ){
                if(response.isSuccessful){
                    //정상적으로 통신이 성공된 경우
                    Log.d("post","onResponse 성공"+response.body().toString());

                    //찜목록에 들어있는 비교해야 함
                    //if(response.body()?.result.contains(id)){ wish.isChecked = true }

                }else{
                    //통신 실패
                    Log.d("post","onResponse 실패")
                }
            }
            override fun onFailure(call: Call<WishResponse>, t: Throwable){
                //통신 실패
                Log.d("get","onFailure 에러"+t.message.toString());
            }
        })


        val commmunalService = RetrofitImpl.getApiClient().create(CommunalService::class.java)
        commmunalService.getTrainerInfo(id).enqueue(object : Callback<GetTrainerInfoResponse> {
            override fun onResponse(call: Call<GetTrainerInfoResponse>, response: Response<GetTrainerInfoResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    onBind(response.body()!!.result)
                    Log.d("post", "onResponse 성공: " + response.body().toString());
                    val body = response.body()
                    body?.let { setAdapter(it.result) }
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
        wish.setOnClickListener { onCheckChanged() }

        //매칭 신청
        val matchRequest =findViewById<Button>(R.id.btn_match_request)
        matchRequest.setOnClickListener {
            val intent = Intent(this, MatchServiceActivity::class.java)
            intent.putExtra("matchIdx",id)
            startActivity(intent)
        }

        val moreAboutMe = findViewById<ImageButton>(R.id.btn_about_me)
        moreAboutMe.setOnClickListener {
            val intent = Intent(this, ProfileAboutMeActivity::class.java)
            intent.putExtra("me",me)
            startActivity(intent)
        }

        val moreAboutService = findViewById<ImageButton>(R.id.btn_about_service)
        moreAboutService.setOnClickListener {
            val intent = Intent(this, ProfileAboutServiceActivity::class.java)
            intent.putExtra("service",service)
            startActivity(intent)
        }

        val report = findViewById<Button>(R.id.btn_report)
        report.setOnClickListener{
            val intent = Intent(this,ProfileReportActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }

        val goBack = findViewById<ImageButton>(R.id.iv_back)
        goBack.setOnClickListener{
            val intent = Intent(this,HomeFragment::class.java)
            startActivity(intent)
        }

        val moreReview = findViewById<ImageButton>(R.id.iv_more_reveiw)
        moreReview.setOnClickListener{
            val intent = Intent(this,ProfileReviewActivity::class.java)
            intent.putExtra("reviewIdx",id)
            startActivity(intent)
        }
    }

    private fun setAdapter(picList: GetTrainerInfoResponse.Result){
        val picAdapter = PicAdapter(picList)
        binding.rvPic.adapter=picAdapter

        binding.rvPic.setHasFixedSize(false)
        binding.rvPic.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) // 가로
    }

    val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)
    private fun onCheckChanged() {
        if (wish.isChecked) {
            customerService.addWish(id).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) { if (response.isSuccessful) {
                        // 정상적으로 통신이 성공된 경우
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        Toast.makeText(this@ProfileActivity, "찜 목록에 추가", Toast.LENGTH_SHORT).show()
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
            customerService.cancelWish(id).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) { if (response.isSuccessful) { // response의 status code가 200~299 사이의
                    // 정상적으로 통신이 성공된 경우
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        Toast.makeText(this@ProfileActivity, "찜 목록에서 제거", Toast.LENGTH_SHORT).show()
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