package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import com.example.fit_i.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPermissionBinding

    private lateinit var allCheckBtn :CheckBox
    private lateinit var firstCheckBtn :CheckBox
    private lateinit var secondCheckBtn :CheckBox
    private lateinit var thirdCheckBtn :CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        binding = ActivityPermissionBinding.inflate(layoutInflater)

        //회원가입하기
        val signIn = findViewById<TextView>(R.id.btn_go_signIn)
        signIn.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }

        allCheckBtn = binding.cbAll
        firstCheckBtn = binding.cb1
        secondCheckBtn = binding.cb2
        thirdCheckBtn = binding.cb3

        allCheckBtn.setOnClickListener {
            onCheckChanged(allCheckBtn)
        Log.d("cb","all")}
        firstCheckBtn.setOnClickListener { onCheckChanged(firstCheckBtn)
            Log.d("cb","1") }
        secondCheckBtn.setOnClickListener { onCheckChanged(secondCheckBtn)
            Log.d("cb","2")}
        thirdCheckBtn.setOnClickListener { onCheckChanged(thirdCheckBtn)
            Log.d("cb","3")}

    }

    private fun onCheckChanged(compoundButton: CompoundButton) {
        when(compoundButton.id) {
            R.id.cbAll -> {
                if (allCheckBtn.isChecked) {
                    firstCheckBtn.isChecked = true
                    secondCheckBtn.isChecked = true
                    thirdCheckBtn.isChecked = true
                }else {
                    firstCheckBtn.isChecked = false
                    secondCheckBtn.isChecked = false
                    thirdCheckBtn.isChecked = false
                }
            }
            else -> {
                allCheckBtn.isChecked = (
                        firstCheckBtn.isChecked
                                && secondCheckBtn.isChecked
                                && thirdCheckBtn.isChecked)
            }
        }
    }
}