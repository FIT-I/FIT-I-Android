package com.example.fit_i.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.ReportRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.RedbellService
import com.example.fit_i.databinding.ActivityProfileReportBinding
import com.example.fit_i.ui.BaseActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileReportActivity:BaseActivity() {
    private lateinit var binding: ActivityProfileReportBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityProfileReportBinding.inflate(layoutInflater)
        val inflater = LayoutInflater.from(this)
        inflater.inflate(R.layout.activity_profile_report, findViewById(R.id.frame_layout), true)
        findViewById<FrameLayout>(R.id.frame_layout).addView(binding.root)
        supportActionBar?.title = "신고하기"

        //아이디 받아오기
        val id = intent.getLongExtra("id",-1)
        Log.d("post",id.toString())

        //사유 선택
        var reason : String ="asdf"
        binding.rgReport.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_report1 -> { reason = "AD" }
                R.id.rb_report2 -> { reason = "FAKE_PROFILE" }
                R.id.rb_report3 -> { reason = "INVALID_LINK" }
                R.id.rb_report4 -> { reason = "BAD_WORD" }
                R.id.rb_report5 -> { reason = "ILLEGAL" }
            }
        }


        val report = findViewById<Button>(R.id.btn_next_step)
        report.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("신고하기")
                .setMessage("정말 신고하시겠습니까?")
                .setPositiveButton("계정신고"
                ) { dialog, which ->
                    //Log.d("MyTag", "positive")
                    val redbellService = RetrofitImpl.getApiClient().create(RedbellService::class.java)
                    redbellService.report(ReportRequest(reason,intent.getLongExtra("id",-1))).enqueue(object : Callback<BaseResponse> {
                        override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                            if(response.isSuccessful){
                                when(response.body()?.code){// 정상적으로 통신이 성공된 경우
                                    1000 -> {
                                        Log.d("post", "onResponse 성공: " + response.body().toString());
                                        Toast.makeText(this@ProfileReportActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
//
                                        startActivity(intent)  // 화면 전환을 시켜줌
                                        finish()
                                    }
                                    else -> {
                                        Log.d("post", "onResponse 오류: " + response.body().toString());
                                        Toast.makeText(this@ProfileReportActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }else{
                                // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                                Log.d("post", "onResponse 실패"+response.code())
                            }
                        }

                        override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                            // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                            Log.d("post", "onFailure 에러: " + t.message.toString());
                        }
                    })
                }
                .setNegativeButton("취소"
                ) { dialog, which -> Log.d("MyTag", "negative") }
                .create()
                .show()
        }
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_profile_report;
    }
}