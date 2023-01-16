package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FindPw2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw2)


        //비밀번호 변경
        val changePW = findViewById<TextView>(R.id.btn_go_main)
        changePW.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}