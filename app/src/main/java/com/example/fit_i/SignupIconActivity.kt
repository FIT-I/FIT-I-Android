package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SignupIconActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_icon)

        val btnIconChoice : Button = findViewById(R.id.btn_icon_choice)

        //버튼 비활성화
        btnIconChoice.isEnabled = false

        //이프 클릭? 하면 이미지의 번호가 저장

        //6개 중 하나를 고르면 버튼 활성화
        //버튼 이벤트
        btnIconChoice.setOnClickListener {
            val intent = Intent(this, LoginSplashActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}