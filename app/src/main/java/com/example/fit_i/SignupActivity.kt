package com.example.fit_i

import android.R.attr.button
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivitySignupBinding


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //객체 생성
        //아이디가 message_edit
        //val messageEdit: EditText = findViewById(R.id.message_edit)
        //val messageBtn: Button = findViewById(R.id.message_btn)
        val etName :EditText = findViewById(R.id.et_name)
        val btnFinSignUp : Button = findViewById(R.id.btn_fin_signUp)

        //메시지 담을 변수
        var name: String = ""

        //버튼 비활성화
        btnFinSignUp.isEnabled = false

        //EditText 값 있을때만 버튼 활성화
        etName.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                //입력값 담기
                name = etName.text.toString()

                //값 유무에 따른 활성화 여부
                btnFinSignUp.isEnabled = name.isNotEmpty() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        //버튼 이벤트
        btnFinSignUp.setOnClickListener {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }


    }//onCreate
//    //회원가입하기
//        val signUp = findViewById<TextView>(R.id.btn_goto_main)
//        signUp.setOnClickListener {
//            val intent = Intent(this, LoginSplashActivity::class.java)
//            startActivity(intent)  // 화면 전환을 시켜줌
//            finish()
//        }

}
