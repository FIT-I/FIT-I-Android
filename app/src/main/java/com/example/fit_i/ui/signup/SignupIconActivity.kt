package com.example.fit_i.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import com.example.fit_i.R
import com.example.fit_i.RetrofitImpl
import com.example.fit_i.data.model.request.SignupValidationRequest
import com.example.fit_i.data.model.request.SignupRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import com.example.fit_i.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupIconActivity : AppCompatActivity() {

    private lateinit var icon1: CheckBox
    private lateinit var icon2: CheckBox
    private lateinit var icon3: CheckBox
    private lateinit var icon4: CheckBox
    private lateinit var icon5: CheckBox
    private lateinit var icon6: CheckBox

    lateinit var name : String
    lateinit var email : String
    lateinit var pw : String

    private lateinit var btnIconChoice: Button

    private var choiceIcon: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_icon)

        val data = intent.getParcelableExtra<SignupValidationRequest>("signup")
        name = data?.name.toString()
        email = data?.email.toString()
        pw = data?.password.toString()


        icon1 = findViewById(R.id.cb_icon1)
        icon2 = findViewById(R.id.cb_icon2)
        icon3 = findViewById(R.id.cb_icon3)
        icon4 = findViewById(R.id.cb_icon4)
        icon5 = findViewById(R.id.cb_icon5)
        icon6 = findViewById(R.id.cb_icon6)

        btnIconChoice= findViewById(R.id.btn_icon_choice)


        //버튼 비활성화
        btnIconChoice.isEnabled = false

        //이프 클릭? 하면 이미지의 번호가 저장

        icon1.setOnClickListener { onCheckChanged(icon1) }
        icon2.setOnClickListener { onCheckChanged(icon2) }
        icon3.setOnClickListener { onCheckChanged(icon3) }
        icon4.setOnClickListener { onCheckChanged(icon4) }
        icon5.setOnClickListener { onCheckChanged(icon5) }
        icon6.setOnClickListener { onCheckChanged(icon6) }


        //6개 중 하나를 고르면 버튼 활성화
        //버튼 이벤트
        btnIconChoice.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)

            val service= RetrofitImpl.getApiClientWithOutToken().create(AccountsService::class.java)

            val signUp = SignupRequest(name,email,pw,"customerProfile${choiceIcon}")
            service.signUpCustomer(signUp).enqueue(object : Callback<BaseResponse> {
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    if(response.isSuccessful){
                        // 정상적으로 통신이 성공된 경우
                        Log.d("post", "onResponse 성공: " + response.body().toString()+SignupRequest(name,email,pw,"customerProfile${choiceIcon}"));
                        startActivity(intent)  // 화면 전환을 시켜줌
                        finish()
                    }else{
                        // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("post", "onResponse 실패"+response.body().toString()+SignupRequest(name,email,pw,"customerProfile${choiceIcon}"))
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                    Log.d("post", "onFailure 에러: " + t.message.toString());
                }
            })
        }
    }

    private fun onCheckChanged(compoundButton: CompoundButton) {
        when (compoundButton.id) {
            R.id.cb_icon1 ->
                if (icon1.isChecked) {
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon = 1
                }

            R.id.cb_icon2 ->
                if (icon2.isChecked) {
                    icon1.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =2
                }
            R.id.cb_icon3 ->
                if (icon3.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =3
                }
            R.id.cb_icon4 ->
                if (icon4.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =4
                }
            R.id.cb_icon5 ->
                if (icon5.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =5
                }
            R.id.cb_icon6 ->
                if (icon6.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    choiceIcon =6
                }
        }

        if(!icon1.isChecked && !icon2.isChecked &&!icon3.isChecked && !icon4.isChecked && !icon5.isChecked &&!icon6.isChecked) {
            choiceIcon=0
            btnIconChoice.isEnabled = false
        }

        if(choiceIcon!=0)
            btnIconChoice.isEnabled = true
    }
}