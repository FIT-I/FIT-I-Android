package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MatchPickUpActivity :AppCompatActivity(){
    private lateinit var pickup1 : CheckBox
    private lateinit var pickup2 : CheckBox
    private lateinit var buttonNext : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_pickup)

        pickup1 = findViewById(R.id.btn_pickup1)
        pickup2 = findViewById(R.id.btn_pickup2)
        buttonNext = findViewById(R.id.btn_next_step)
        buttonNext.isEnabled = false

        pickup1.setOnClickListener{onCheckChanged(pickup1)}
        pickup2.setOnClickListener{onCheckChanged(pickup2)}

        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this,MatchDateChooseActivity::class.java)
            startActivity(intent)
            finish()
        }
        //픽업 다음 단계로 이동
        val nextStep = findViewById<TextView>(R.id.btn_next_step)
        nextStep.setOnClickListener{
            val intent = Intent(this,MatchCheckActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
    private fun onCheckChanged(compoundButton: CompoundButton){
        when(compoundButton.id){
            R.id.btn_pickup1-> {
                if (pickup1.isChecked) {
                    pickup2.isChecked = false
                    buttonNext.isEnabled = true
                }
            }
            R.id.btn_pickup2->{
                if(pickup2.isChecked){
                    pickup1.isChecked = false
                    buttonNext.isEnabled = true
                }
            }

        }
        buttonNext.isEnabled = pickup1.isChecked
        buttonNext.isEnabled = pickup2.isChecked
    }
}
