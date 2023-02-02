package com.example.fit_i.ui.main.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.data.service.CustomerService
import com.example.fit_i.ui.main.MainActivity
import com.example.fit_i.ui.signup.SignupActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Path

class MypageLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_location2)

        val etLocation = findViewById<EditText>(R.id.et_location)
        var location : String =""
        val btnOk = findViewById<Button>(R.id.btn_fin_location)

        //EditText 값 있을때만 버튼 활성화
        etLocation.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                location= etLocation.text.toString()

                //stroke 색상변경
                if(location.isNotEmpty())
                    etLocation.setBackgroundResource(R.drawable.edittext_border)
                else
                    etLocation.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnOk.isEnabled = location.isNotEmpty() //있다면 true 없으면 false
            }
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        btnOk.setOnClickListener(){
            val customerService = RetrofitImpl.getApiClient().create(CustomerService::class.java)

            customerService.setLocation(location).enqueue(object :
                Callback<BaseResponse> {
                //fun setLocation(@Path("location") location:String):Call<BaseResponse>
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    if(response.isSuccessful){
                        // 정상적으로 통신이 성공된 경우
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        //Toast.makeText(this, response.body()?.result.toString(), Toast.LENGTH_SHORT).show()
                        finish() //현재 액티비티가 닫힘 굳
                    }
                    else{
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


}