package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ServiceActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        //서비스선택 다음단계로 이동
        val nextStep = findViewById<TextView>(R.id.button_next)
        nextStep.setOnClickListener{
            val intent = Intent(this,DateChooseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}