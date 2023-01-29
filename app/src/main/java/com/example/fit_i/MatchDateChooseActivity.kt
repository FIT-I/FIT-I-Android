package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MatchDateChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_date_choose)
        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this,MatchServiceActivity::class.java)
            startActivity(intent)
            finish()
        }
        //날짜선택 다음 단계로 이동
        val nextStep = findViewById<TextView>(R.id.btn_next)
        nextStep.setOnClickListener{
            val intent = Intent(this,MatchPickUpActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}