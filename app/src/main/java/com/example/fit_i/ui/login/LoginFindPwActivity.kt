package com.example.fit_i.ui.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.databinding.ActivityFindPwBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFindPwActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFindPwBinding

    var emailF: String=""
    var codeF:String=""
    var returnCode : String =""
    lateinit var codeWrongMessage : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw)

        binding = ActivityFindPwBinding.inflate(layoutInflater)

        val etEmailF : EditText= findViewById(R.id.et_emailF)
        val etCodeF :EditText = findViewById(R.id.et_tempPwF)
        val btnFindPw : Button = findViewById(R.id.btn_find_pw)
        codeWrongMessage = findViewById(R.id.tv_wrong_code)

        btnFindPw.isEnabled = false
        btnFindPw.text="인증코드 받기"

        etCodeF.visibility= View.INVISIBLE
        codeWrongMessage.visibility = View.INVISIBLE

        etEmailF.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                emailF = etEmailF.text.toString()

                //stroke 색상변경
                if(emailF.isNotEmpty())
                    etEmailF.setBackgroundResource(R.drawable.edittext_border)
                else
                    etEmailF.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFindPw.isEnabled = emailF.isNotEmpty()

                btnFindPw.setOnClickListener(){
                    if(btnFindPw.isEnabled)
                        etCodeF.visibility= View.VISIBLE

                    val accountService = RetrofitImpl.getApiClient().create(AccountsService::class.java)
                    accountService.sendEmail(emailF).enqueue(object : Callback<BaseResponse> {
                        override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                            if(response.isSuccessful){
                                // 정상적으로 통신이 성공된 경우
                                Log.d("post", "onResponse 성공: " + response.body().toString());
                                Toast.makeText(this@LoginFindPwActivity, "이메일이 전송되었습니다.", Toast.LENGTH_SHORT).show()
                                returnCode= response.body()?.result.toString()
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
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etCodeF.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                codeF = etCodeF.text.toString()
                if (btnFindPw.text=="인증코드 받기")
                        btnFindPw.text="완료"

                //stroke 색상변경
                if(codeF.isNotEmpty())
                    etCodeF.setBackgroundResource(R.drawable.edittext_border)
                else
                    etCodeF.setBackgroundResource(R.drawable.edittext_border_not)

                btnFindPw.setOnClickListener {
                    letgo()
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun letgo() {
        val intent = Intent(this, LoginSplashActivity::class.java)

        val service = RetrofitImpl.getApiClient().create(AccountsService::class.java)
        service.findPW(emailF).enqueue(object : Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    if(codeF== returnCode){
                        codeWrongMessage.visibility = View.INVISIBLE

                        Toast.makeText(this@LoginFindPwActivity,
                            "비밀번호 찾기 성공!", Toast.LENGTH_SHORT).show()
                        Log.d("post", "onResponse 성공: " + response.body().toString());
                        startActivity(intent)  // 화면 전환을 시켜줌
                        finish()
                    }
                    else{//(인증코드가 잘못되었습니다. 다시 확인해 주세요)
                        codeWrongMessage.visibility = View.VISIBLE
                        codeWrongMessage.setTextColor(Color.RED)
                    }

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
    }
}