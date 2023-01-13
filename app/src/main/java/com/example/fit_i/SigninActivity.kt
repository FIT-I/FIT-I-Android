package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        //회원가입하기
        val signIn = findViewById<TextView>(R.id.btn_goto_main)
        signIn.setOnClickListener {
            val intent = Intent(this, LoginSplashActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}