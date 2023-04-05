package com.example.fit_i.ui.match

import android.content.DialogInterface
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
import com.example.fit_i.data.model.request.MatchingRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.databinding.ActivityMatchCheck1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchCheckActivity2 :AppCompatActivity(){
    private lateinit var binding:ActivityMatchCheck1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMatchCheck1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getLongExtra("matchIdx",-1)
        val start=intent.getStringExtra("start")
        val end=intent.getStringExtra("end")

        //binding.tvPrice.text=f
        binding.tvDateStart.text=start
        binding.tvDateEnd.text=end


        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener{
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("매칭 요청")
            dialog.setMessage("매칭을 요청하시겠습니까?")
            //dialog.setIcon(R.drawable.icon5)

            fun makeToast() {
                Toast.makeText(this@MatchCheckActivity2, "매칭 요청을 완료하였습니다.", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
                finish()
            }

            fun logout() {
                val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)

                customerService.matcingPlz(MatchingRequest(end!!,start!!,"TRINAER_GO") ,id).enqueue(object :
                    Callback<BaseResponse> {
                    override fun onResponse(
                        call: Call<BaseResponse>,
                        response: Response<BaseResponse>
                    ) {
                        if (response.isSuccessful) {
                            // 정상적으로 통신이 성공된 경우
                            Log.d("post", "onResponse 성공: " + response.body().toString());
                            makeToast()
                        } else {
                            // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                            //Log.d("post", response.code().toString()+"onResponse 실패 "+ response.body().toString()+token)
                            Log.d("post", "onResponse 실패 " + response.body().toString() )
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                        // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                        Log.d("post", "onFailure 에러: " + t.message.toString());
                    }
                })
            }

            val dialog_listener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        logout()
                    }
                }
            }
            dialog.setPositiveButton("매칭신청", dialog_listener)
            dialog.setNegativeButton("취소", null)
            dialog.show()
        }

        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, MatchPickUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}