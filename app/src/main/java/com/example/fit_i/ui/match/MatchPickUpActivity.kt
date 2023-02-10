package com.example.fit_i.ui.match

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R

class MatchPickUpActivity :AppCompatActivity(){
    private lateinit var pickup1 : CheckBox
    private lateinit var pickup2 : CheckBox
    private lateinit var buttonNext : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_pickup)

        val id = intent.getLongExtra("matchIdx",-1)
        val start = intent.getStringExtra("start")
        val end = intent.getStringExtra("end")

        pickup1 = findViewById(R.id.btn_pickup1)
        pickup2 = findViewById(R.id.btn_pickup2)
        buttonNext = findViewById(R.id.btn_next_step)
        buttonNext.isEnabled = false

        pickup1.setOnClickListener{onCheckChanged(pickup1)}
        pickup2.setOnClickListener{onCheckChanged(pickup2)}

        //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, MatchDateChooseActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonNext.setOnClickListener{
            if(pickup1.isChecked){
                val intent = Intent(this, MatchCheckActivity1::class.java)
                intent.putExtra("matchIdx",id)
                intent.putExtra("start",start)
                intent.putExtra("end",end)
                startActivity(intent)
                finish()
            }
            else{
                val intent = Intent(this, MatchCheckActivity2::class.java)
                intent.putExtra("matchIdx",id)
                intent.putExtra("start",start)
                intent.putExtra("end",end)
                startActivity(intent)
                finish()
            }
        }

    }
    private fun onCheckChanged(compoundButton: CompoundButton){
        when(compoundButton.id){
            R.id.btn_pickup1 -> {
                if (pickup1.isChecked) {
                    pickup2.isChecked = false
                    buttonNext.isEnabled = true
                }
                else{
                    buttonNext.isEnabled = false
                }
            }
            R.id.btn_pickup2 ->{
                if(pickup2.isChecked){
                    pickup1.isChecked = false
                    buttonNext.isEnabled = true
                }
                else{
                    buttonNext.isEnabled = false
                }
            }

        }
    }
}
