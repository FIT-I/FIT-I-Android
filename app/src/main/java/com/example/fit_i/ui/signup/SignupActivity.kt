package com.example.fit_i.ui.signup

import com.example.fit_i.data.model.request.SignupValidationRequest
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.databinding.ActivityLoginBinding
import com.example.fit_i.databinding.ActivitySignupBinding
import com.example.fit_i.ui.BaseActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern


class SignupActivity : BaseActivity() {
    private lateinit var binding: ActivitySignupBinding

    //메시지 담을 변수
    var name: String = ""
    var email: String = ""
    var pw: String = ""
    var pw2: String = ""

    val emailPattern =
        "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$"
    val pwPattern = "^.*(?=^.{5,15}\$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#\$%^&+=]).*$"

    private lateinit var confirmPW: TextView
    private lateinit var special: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // MainActivity의 레이아웃을 frame_layout에 추가
        val inflater = LayoutInflater.from(this)
        inflater.inflate(R.layout.activity_signup, findViewById(R.id.frame_layout), true)

        supportActionBar?.title = "회원가입"

        //setContentView(R.layout.activity_signup)

        binding = ActivitySignupBinding.inflate(layoutInflater)

        //객체 생성
        val etName: EditText = findViewById(R.id.et_name)
        val etEmail: EditText = findViewById(R.id.et_email)
        val etPW: EditText = findViewById(R.id.et_pw)
        val etPW2: EditText = findViewById(R.id.et_pw2)

        confirmPW = findViewById(R.id.tv_pwConfirm)
        special = findViewById(R.id.tv_special)

        val btnFinSignUp: Button = findViewById(R.id.btn_fin_signUp)

        //버튼 비활성화
        btnFinSignUp.isEnabled = false

        //EditText 값 있을때만 버튼 활성화
        etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                name = etName.text.toString()

                //stroke 색상변경
                if (name.isNotEmpty())
                    etName.setBackgroundResource(R.drawable.edittext_border)
                else
                    etName.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {}
        })


        etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                email = etEmail.text.toString()

                //stroke 색상변경
                if (email.isNotEmpty())
                    etEmail.setBackgroundResource(R.drawable.edittext_border)
                else
                    etEmail.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {}
        })


        //(! @ # $ % ^ &amp; + =
        etPW.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw = etPW.text.toString()

                //stroke 색상변경
                if (pw.isNotEmpty())
                    etPW.setBackgroundResource(R.drawable.edittext_border)
                else
                    etPW.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        etPW2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw2 = etPW2.text.toString()

                //stroke 색상변경
                if (pw2.isNotEmpty())
                    etPW2.setBackgroundResource(R.drawable.edittext_border)
                else
                    etPW2.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        //회원가입하기
        //버튼 이벤트
        btnFinSignUp.setOnClickListener {

            val intent = Intent(this, SignupIconActivity::class.java)

            val service= RetrofitImpl.getApiClientWithOutToken().create(AccountsService::class.java)
            service.signupCheckValidation(SignupValidationRequest(email,name,pw)).enqueue(object: Callback<BaseResponse> {
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    if(response.isSuccessful){
                        when(response.body()?.code){// 정상적으로 통신이 성공된 경우
                          1000 -> {
                              Log.d("post", "onResponse 성공: " + response.body().toString()+SignupValidationRequest(name,email,pw));
                              Toast.makeText(this@SignupActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                              intent.putExtra("signup",(SignupValidationRequest(email,name,pw)))
//
                              startActivity(intent)  // 화면 전환을 시켜줌
                              finish()
                          }
                          else -> {
                              Log.d("post", "onResponse 오류: " + response.body().toString());
                              Toast.makeText(this@SignupActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                          }
                        }

                    }else{
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패")
                        Toast.makeText(this@SignupActivity, response.body()!!.message, Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            })
        }
    }

    //네 개 다 입력 & 이메일 정규성 & 비밀번호 일치 & 비밀번호 정규성
    private fun isTrue(): Boolean {
        pwDoubleCheck()
        pwCheck()
        emailCheck()
        return name.isNotEmpty() && email.isNotEmpty() && pw.isNotEmpty() && pw2.isNotEmpty() && emailCheck() && pwDoubleCheck() && pwCheck()
    }

    //이메일 정규성 검사
    private fun emailCheck(): Boolean {
        val pattern1 = Pattern.compile(emailPattern) // 패턴 컴파일
        val matcher1 = pattern1.matcher(email)

        return if (!matcher1.find()) {
            //Toast.makeText(this@SignupActivity, "이메일 형식을 확인해주세요", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    //패스워드 정규성검사
    private fun pwCheck(): Boolean {
        val pattern2 = Pattern.compile(pwPattern) // 패턴 컴파일
        val matcher2 = pattern2.matcher(pw)

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
        if (pw == pw2) {
            confirmPW.text = " "
            return true
        } else {
            confirmPW.text = "비밀번호가 일치하지 않습니다."
            confirmPW.setTextColor(Color.parseColor("#FF0000"))
            return false
        }

    }
}