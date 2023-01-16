package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PickUpActivity :AppCompatActivity(){
    private lateinit var pickup1 : CheckBox
    private lateinit var pickup2 : CheckBox
    private lateinit var buttonNext : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup)

        pickup1 = findViewById(R.id.pickup1_btn)
        pickup2 = findViewById(R.id.pickup2_btn)
        buttonNext = findViewById(R.id.button_next)
        buttonNext.isEnabled = false

        pickup1.setOnClickListener{onCheckChanged(pickup1)}
        pickup2.setOnClickListener{onCheckChanged(pickup2)}

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
    private fun onCheckChanged(compoundButton: CompoundButton){
        when(compoundButton.id){
            R.id.pickup1_btn-> {
                if (pickup1.isChecked) {
                    pickup2.isChecked = false
                    buttonNext.isEnabled = true
                }
            }
            R.id.pickup2_btn->{
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
