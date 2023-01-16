package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView

class ServiceActivity :AppCompatActivity(){
    private lateinit var checkBox: CheckBox
    private lateinit var buttonNext : Button
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        checkBox = findViewById(R.id.checkBox)
        buttonNext=findViewById(R.id.button_next)
        buttonNext.isEnabled = false

        checkBox.setOnClickListener{ onCheckChanged(checkBox)}


        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        //서비스선택 다음단계로 이동


        buttonNext.setOnClickListener{
            val intent = Intent(this,DateChooseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun onCheckChanged(compoundButton: CompoundButton){
        when(compoundButton.id){
            R.id.checkBox->{
            if(checkBox.isChecked){
                buttonNext.isEnabled = true
            }
            }
        }

        buttonNext.isEnabled = checkBox.isChecked

    }
}