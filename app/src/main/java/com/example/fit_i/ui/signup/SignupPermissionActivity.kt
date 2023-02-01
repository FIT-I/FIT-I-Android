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
import com.example.fit_i.data.model.request.TermsOkRequest
import com.example.fit_i.data.model.response.BaseResponse
import com.example.fit_i.data.service.AccountsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupPermissionActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityPermissionBinding

    private lateinit var allCheckBtn : CheckBox
    private lateinit var firstCheckBtn : CheckBox
    private lateinit var secondCheckBtn : CheckBox
    private lateinit var thirdCheckBtn : CheckBox
    private lateinit var btnGoSignIn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_permission)

        allCheckBtn = findViewById(R.id.cbAll)
        firstCheckBtn=findViewById(R.id.cb1)
        secondCheckBtn= findViewById(R.id.cb2)
        thirdCheckBtn = findViewById(R.id.cb3)
        btnGoSignIn= findViewById(R.id.btn_go_signIn)
        btnGoSignIn.isEnabled = false

        allCheckBtn.setOnClickListener { onCheckChanged(allCheckBtn) }
        firstCheckBtn.setOnClickListener { onCheckChanged(firstCheckBtn) }
        secondCheckBtn.setOnClickListener { onCheckChanged(secondCheckBtn) }
        thirdCheckBtn.setOnClickListener { onCheckChanged(thirdCheckBtn) }

        btnGoSignIn.setOnClickListener(){
            fun makeToast(){
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)  // 화면 전환을 시켜줌
                finish()
            }
            fun postTerms(){
                val service = RetrofitImpl.getApiClient().create(AccountsService::class.java)
                var checked = TermsOkRequest(firstCheckBtn.isChecked,secondCheckBtn.isChecked,thirdCheckBtn.isChecked)
                service.termsOk(checked).enqueue(object : Callback<BaseResponse> {
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
                            Log.d("post", "onResponse 실패 "+ response.body().toString())
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                        // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                        Log.d("post", "onFailure 에러: " + t.message.toString());
                    }
                })
            }
            postTerms()
        }

    }

    private fun onCheckChanged(compoundButton: CompoundButton) {
        when(compoundButton.id) {
            R.id.cbAll -> {
                if (allCheckBtn.isChecked) {
                    firstCheckBtn.isChecked = true
                    secondCheckBtn.isChecked = true
                    thirdCheckBtn.isChecked = true

                    btnGoSignIn.isEnabled = true

                }else {
                    firstCheckBtn.isChecked = false
                    secondCheckBtn.isChecked = false
                    thirdCheckBtn.isChecked = false
                }
            }
            else -> {
                allCheckBtn.isChecked = (
                        firstCheckBtn.isChecked
                                && secondCheckBtn.isChecked
                                && thirdCheckBtn.isChecked )}
        }

        btnGoSignIn.isEnabled = allCheckBtn.isChecked
    }

//    private fun isTrue(): Boolean {
//        return name.isNotEmpty()&&email.isNotEmpty()&&pw.isNotEmpty()&&pw2.isNotEmpty()
//    }
}