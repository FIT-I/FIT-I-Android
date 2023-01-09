package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ChangePwActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_pw)

        //비밀번호 변경
        val GoMain = findViewById<TextView>(R.id.btn_go_main)
        GoMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }
}