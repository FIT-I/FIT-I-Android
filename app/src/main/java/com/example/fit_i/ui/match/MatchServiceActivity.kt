package com.example.fit_i.ui.match

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import com.example.fit_i.R
import com.example.fit_i.ui.profile.ProfileActivity

class MatchServiceActivity :AppCompatActivity(){
    private lateinit var checkBox: CheckBox
    private lateinit var buttonNext : Button
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_service)

        checkBox = findViewById(R.id.cb_check_service)
        buttonNext=findViewById(R.id.btn_next_step)
        buttonNext.isEnabled = false

        checkBox.setOnClickListener{ onCheckChanged(checkBox)}


        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        //서비스선택 다음단계로 이동


        buttonNext.setOnClickListener{
            val intent = Intent(this, MatchDateChooseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun onCheckChanged(compoundButton: CompoundButton){
        when(compoundButton.id){
            R.id.cb_check_service ->{
            if(checkBox.isChecked){
                buttonNext.isEnabled = true
            }
            }
        }

        buttonNext.isEnabled = checkBox.isChecked

    }
}