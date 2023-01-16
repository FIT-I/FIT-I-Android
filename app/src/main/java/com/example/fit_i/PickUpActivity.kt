package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PickUpActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup)
        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this,DateChooseActivity::class.java)
            startActivity(intent)
            finish()
        }
        //픽업 다음 단계로 이동
        val nextStep = findViewById<TextView>(R.id.button_next)
        nextStep.setOnClickListener{
            val intent = Intent(this,CheckMatchingActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}