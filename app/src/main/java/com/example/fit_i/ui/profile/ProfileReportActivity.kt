package com.example.fit_i.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.ReportRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.RedbellService
import com.example.fit_i.databinding.ActivityProfileReportBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileReportActivity:AppCompatActivity() {
    private lateinit var binding: ActivityProfileReportBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityProfileReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //아이디 받아오기
        //val id = intent.getLongExtra("id",-1)
        //Log.d("post",id.toString())

        val goBack = findViewById<ImageButton>(R.id.ib_close)
        goBack.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        //사유 선택
        var reason : String ="asdf"
        binding.rgReport.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_report1 -> { reason = "요청서와 관련없는 광고/홍보/영업" }
                R.id.rb_report2 -> { reason = "허위 프로필 작성" }
                R.id.rb_report3 -> { reason = "유효하지 않은 카카오톡 링크" }
                R.id.rb_report4 -> { reason = "관련 법령 등을 위반하는 요청" }
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
                                // 정상적으로 통신이 성공된 경우
                                Log.d("post", "onResponse 성공: " + response.body().toString());
                                Toast.makeText(this@ProfileReportActivity, "신고가 접수되었습니다다.", Toast.LENGTH_SHORT).show()
                                finish()
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
}