package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast

class SignupIconActivity : AppCompatActivity() {


    private lateinit var icon1: CheckBox
    private lateinit var icon2: CheckBox
    private lateinit var icon3: CheckBox
    private lateinit var icon4: CheckBox
    private lateinit var icon5: CheckBox
    private lateinit var icon6: CheckBox

    private lateinit var btnIconChoice: Button

    //private lateinit var icon5 : Button
    private var choiceIcon: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_icon)

        icon1 = findViewById(R.id.cb_icon1)
        icon2 = findViewById(R.id.cb_icon2)
        icon3 = findViewById(R.id.cb_icon3)
        icon4 = findViewById(R.id.cb_icon4)
        icon5 = findViewById(R.id.cb_icon5)
        icon6 = findViewById(R.id.cb_icon6)

        btnIconChoice= findViewById(R.id.btn_icon_choice)


        //버튼 비활성화
        btnIconChoice.isEnabled = false

        //이프 클릭? 하면 이미지의 번호가 저장

        icon1.setOnClickListener { onCheckChanged(icon1) }
        icon2.setOnClickListener { onCheckChanged(icon2) }
        icon3.setOnClickListener { onCheckChanged(icon3) }
        icon4.setOnClickListener { onCheckChanged(icon4) }
        icon5.setOnClickListener { onCheckChanged(icon5) }
        icon6.setOnClickListener { onCheckChanged(icon6) }


        //6개 중 하나를 고르면 버튼 활성화
        //버튼 이벤트
        btnIconChoice.setOnClickListener {
            val intent = Intent(this, LoginSplashActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }

    private fun onCheckChanged(compoundButton: CompoundButton) {
        when (compoundButton.id) {
            R.id.cb_icon1 ->
                if (icon1.isChecked) {
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon = 1
                }

            R.id.cb_icon2 ->
                if (icon2.isChecked) {
                    icon1.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =2
                }
            R.id.cb_icon3 ->
                if (icon3.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =3
                }
            R.id.cb_icon4 ->
                if (icon4.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon5.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =4
                }
            R.id.cb_icon5 ->
                if (icon5.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon6.isChecked = false
                    choiceIcon =5
                }
            R.id.cb_icon6 ->
                if (icon6.isChecked) {
                    icon1.isChecked = false
                    icon2.isChecked = false
                    icon3.isChecked = false
                    icon4.isChecked = false
                    icon5.isChecked = false
                    choiceIcon =6
                }
        }
        if(choiceIcon!=0)
            btnIconChoice.isEnabled = true
    }
}