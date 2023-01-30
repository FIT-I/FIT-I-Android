package com.example.fit_i.ui.mypage

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import com.example.fit_i.ui.login.LoginSplashActivity
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.ChangePWRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.databinding.ActivityChangePwBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class MypageChangePwActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePwBinding

    var pw1: String=""
    var pw2: String=""

    val pwPattern = "^.*(?=^.{5,15}\$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#\$%^&+=]).*$"

    private lateinit var confirmPW: TextView //비밀번호 일치
    private lateinit var special: TextView //비밀번호 정규성

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_pw)

        binding = ActivityChangePwBinding.inflate(layoutInflater)

        val etPw1 : EditText = findViewById(R.id.et_newPw1)
        val etPw2 : EditText = findViewById(R.id.et_newPw2)

        confirmPW = findViewById(R.id.tv_confirmC)
        special = findViewById(R.id.tv_specialC)

        val btnFinPwChange : Button = findViewById(R.id.btn_fin_pw_change)

        btnFinPwChange.isEnabled = false

        etPw1.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw1 = etPw1.text.toString()

                //stroke 색상변경
                if (pw1.isNotEmpty())
                    etPw1.setBackgroundResource(R.drawable.edittext_border)
                else
                    etPw1.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinPwChange.isEnabled = isTrue()
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etPw2.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw2 = etPw2.text.toString()

                //stroke 색상변경
                if (pw2.isNotEmpty())
                    etPw2.setBackgroundResource(R.drawable.edittext_border)
                else
                    etPw2.setBackgroundResource(R.drawable.edittext_border_not)

                btnFinPwChange.isEnabled = isTrue() //있다면 true 없으면 false
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        //비밀번호 변경 끝!
        //버튼 이벤트
        btnFinPwChange.setOnClickListener {
            val intent = Intent(this, LoginSplashActivity::class.java)
            val service = RetrofitImpl.getApiClient().create(AccountsService::class.java)

            service.changePW(ChangePWRequest("", pw1,"")).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    if(response.isSuccessful){
                        // 정상적으로 통신이 성공된 경우
                        //val result: User? = response.body()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        Toast.makeText(this@MypageChangePwActivity, "비밀번호가 변경되었습니다.", Toast.LENGTH_SHORT).show()
                        //Log.d("post","result: "+response.)
                        //Log.d("post", "onResponse 성공: " + result.toString());
                    }else{
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패")
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            })



        startActivity(intent)  // 화면 전환을 시켜줌
            finish()
            Toast.makeText(this, pw1 + " changePW", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isTrue(): Boolean {
        pwDoubleCheck()
        pwCheck()
        return pw1.isNotEmpty() && pw2.isNotEmpty() && pwCheck() && pwDoubleCheck()
    }

    //비밀번호 정규성 검사
    private fun pwCheck(): Boolean {
        val pattern2 = Pattern.compile(pwPattern) // 패턴 컴파일
        val matcher2 = pattern2.matcher(pw1)

        return if (!matcher2.find()) {
            special.text = "(영문, 숫자, 특수문자(! @ # \$ % ^ & + =) 를 포함해 5자 이상으로 입력해주세요)"
            special.setTextColor(Color.parseColor("#FF0000"))
            false
        } else {
            special.text = " "
            //special.setTextColor(Color.parseColor("#D9D9D9"))
            true
        }
    }

    //패스워드 일치 검사 로직
    private fun pwDoubleCheck(): Boolean {
        if (pw1 == pw2) {
            confirmPW.text = "새로운 비밀번호와 일치합니다."
            confirmPW.setTextColor(Color.parseColor("#159500"))
            return true
        } else {
            confirmPW.text = "비밀번호가 일치하지 않습니다."
            confirmPW.setTextColor(Color.parseColor("#FF0000"))
            return false
        }
    }
}