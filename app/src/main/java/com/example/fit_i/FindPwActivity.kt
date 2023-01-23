package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivityFindPwBinding

class FindPwActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFindPwBinding

    var emailF: String=""
    var tempPW:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw)

        binding = ActivityFindPwBinding.inflate(layoutInflater)

        val etEmailF : EditText= findViewById(R.id.et_emailF)
        val etTempPwF :EditText = findViewById(R.id.et_tempPwF)
        val btnFindPw : Button = findViewById(R.id.btn_find_pw)

        btnFindPw.isEnabled = false
        btnFindPw.text="임시 비밀번호 발급"

        etTempPwF.visibility= View.INVISIBLE

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
                        etTempPwF.visibility= View.VISIBLE}
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        etTempPwF.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //입력값 담기
                tempPW = etTempPwF.text.toString()
                if (btnFindPw.text=="임시 비밀번호 발급")
                        btnFindPw.text="로그인"


                //stroke 색상변경
                if(tempPW.isNotEmpty())
                    etTempPwF.setBackgroundResource(R.drawable.edittext_border)
                else
                    etTempPwF.setBackgroundResource(R.drawable.edittext_border_not)


                btnFindPw.setOnClickListener {
                    letgo()
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun letgo() {
        val intent = Intent(this, LoginSplashActivity::class.java)
        startActivity(intent)  // 화면 전환을 시켜줌
        finish()
        Toast.makeText(this, emailF + "findPW", Toast.LENGTH_SHORT).show()
    }
}