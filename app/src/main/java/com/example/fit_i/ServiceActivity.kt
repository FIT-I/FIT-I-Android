package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class ServiceActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
        //서비스선택 다음단계로 이동
        val nextStep = findViewById<TextView>(R.id.button_next)
        nextStep.setOnClickListener{
            val intent = Intent(this,DateChooseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}