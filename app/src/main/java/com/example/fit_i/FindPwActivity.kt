package com.example.fit_i

import android.R.attr.button
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivityFindPwBinding

class FindPwActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFindPwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw)

        binding = ActivityFindPwBinding.inflate(layoutInflater)


        //비밀번호 변경
        val changePW = findViewById<TextView>(R.id.btn_go_next)
        changePW.setOnClickListener {
            val intent = Intent(this, FindPw2Activity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }

        binding.etEmailAddressF.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.isNotEmpty()) {
                    binding.btnGoNext.isClickable = true
                    binding.btnGoNext.setBackgroundColor(Color.BLUE)
                } else {
                    binding.btnGoNext.isClickable = false
                    binding.btnGoNext.setBackgroundColor(Color.GRAY)
                }
            }
        })
    }
}