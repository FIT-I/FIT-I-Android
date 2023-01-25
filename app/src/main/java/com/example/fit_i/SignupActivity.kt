package com.example.fit_i

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.RetrofitImpl.service
import com.example.fit_i.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    //메시지 담을 변수
    var name: String = ""
    var email : String=""
    var pw: String=""
    var pw2: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //객체 생성
        val etName :EditText = findViewById(R.id.et_name)
        val etEmail : EditText = findViewById(R.id.et_email)
        val etPW : EditText = findViewById(R.id.et_pw)
        val etPW2: EditText = findViewById(R.id.et_pw2)
        val ConfirmPW: TextView = findViewById(R.id.tv_pwConfirm)

        val btnFinSignUp : Button = findViewById(R.id.btn_fin_signUp)


/*
//        val signUp = User(name,email,pw,"example")
        val signUp = User("홍길동","fiti@soongsil.ac.kr","fiti123!","customerProfile1")
        service.postSignup(signUp).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    val result: User? = response.body()
                    Log.d("post", "onResponse 성공: " + result?.toString());
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("post", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("post", "onFailure 에러: " + t.message.toString());
            }
        })
*/

        //버튼 비활성화
        btnFinSignUp.isEnabled = false

        //EditText 값 있을때만 버튼 활성화
        etName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                name = etName.text.toString()

                //stroke 색상변경
                if(name.isNotEmpty())
                    etName.setBackgroundResource(R.drawable.edittext_border)
                else
                    etName.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etEmail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                email = etEmail.text.toString()


                //stroke 색상변경
                if(email.isNotEmpty())
                    etEmail.setBackgroundResource(R.drawable.edittext_border)
                else
                    etEmail.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
           }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etPW.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw = etPW.text.toString()

                //stroke 색상변경
                if(pw.isNotEmpty())
                    etPW.setBackgroundResource(R.drawable.edittext_border)
                else
                    etPW.setBackgroundResource(R.drawable.edittext_border_not)
                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etPW2.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                pw2 = etPW2.text.toString()

                //stroke 색상변경
                if(pw2.isNotEmpty())
                    etPW2.setBackgroundResource(R.drawable.edittext_border)
                else
                    etPW2.setBackgroundResource(R.drawable.edittext_border_not)

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = isTrue() //있다면 true 없으면 false


                //비밀번호 확인 일치 로직
                if(etPW.text.toString() == etPW2.text.toString()){
                    ConfirmPW.text = " "
//                    ConfirmPW.setTextColor(colorMain)
                    // 가입하기 버튼 활성화
                    btnFinSignUp.isEnabled=isTrue()&&true
                }
                else{
                    ConfirmPW.text = "비밀번호가 일치하지 않습니다."
                    ConfirmPW.setTextColor(Color.parseColor("#FF0000"))
                    // 가입하기 버튼 비활성화
                    btnFinSignUp.isEnabled=isTrue()&&false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if(etPW.text.toString() == etPW2.text.toString()){
                    ConfirmPW.text = " "
                    //ConfirmPW.setTextColor(ma)
                    // 가입하기 버튼 활성화
                    btnFinSignUp.isEnabled=isTrue()&&true
                }
                else{
                    ConfirmPW.text = "비밀번호가 일치하지 않습니다."
                    ConfirmPW.setTextColor(Color.parseColor("#FF0000"))
                    // 가입하기 버튼 비활성화
                    btnFinSignUp.isEnabled=isTrue()&&false
                }
            }
        })


        //비밀번호 조건




        //비밀번호 눈 아이콘

        val ivEye1 : ImageView = findViewById(R.id.iv_eye1)
        val ivEye2 : ImageView =findViewById(R.id.iv_eye2)

        ivEye1.setOnClickListener(){
            if(ivEye1.tag.equals("0")){//비밀번호 안 보이고 있던 상황
                ivEye1.tag = "1"
                ivEye1.setImageResource(R.drawable.ic_eye)
                etPW.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }else{//비밀번호 보이고 있던 상황
                ivEye1.tag = "0"
                ivEye1.setImageResource(R.drawable.ic_eye_slash)
                etPW.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etPW.setSelection(etPW.text.length)
            //etPW2.setSelection(etPW.text.length)
        }

        ivEye2.setOnClickListener(){
            if(ivEye2.tag.equals("0")){//비밀번호 안 보이고 있던 상황
                ivEye2.tag = "1"
                ivEye2.setImageResource(R.drawable.ic_eye)
                etPW.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }else{//비밀번호 보이고 있던 상황
                ivEye2.tag = "0"
                ivEye2.setImageResource(R.drawable.ic_eye_slash)
                etPW2.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            //etPW.setSelection(etPW.text.length)
            etPW2.setSelection(etPW.text.length)
        }


        //회원가입하기
        //버튼 이벤트
        btnFinSignUp.setOnClickListener {
            val intent = Intent(this, SignupIconActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        Toast.makeText(this, name+"signUp", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isTrue(): Boolean {
        return name.isNotEmpty()&&email.isNotEmpty()&&pw.isNotEmpty()&&pw2.isNotEmpty()
    }
}
