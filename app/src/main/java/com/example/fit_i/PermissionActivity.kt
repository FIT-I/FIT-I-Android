package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import com.example.fit_i.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityPermissionBinding

    private lateinit var allCheckBtn : CheckBox
    private lateinit var firstCheckBtn : CheckBox
    private lateinit var secondCheckBtn : CheckBox
    private lateinit var thirdCheckBtn : CheckBox
    private lateinit var btnGoSignIn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)


        allCheckBtn = findViewById(R.id.cbAll)
        firstCheckBtn=findViewById(R.id.cb1)
        secondCheckBtn= findViewById(R.id.cb2)
        thirdCheckBtn = findViewById(R.id.cb3)
        btnGoSignIn= findViewById(R.id.btn_go_signIn)
        btnGoSignIn.isEnabled = false

        allCheckBtn.setOnClickListener { onCheckChanged(allCheckBtn) }
        firstCheckBtn.setOnClickListener { onCheckChanged(firstCheckBtn) }
        secondCheckBtn.setOnClickListener { onCheckChanged(secondCheckBtn) }
        thirdCheckBtn.setOnClickListener { onCheckChanged(thirdCheckBtn) }

        btnGoSignIn.setOnClickListener(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()
        }
    }

    private fun onCheckChanged(compoundButton: CompoundButton) {
        when(compoundButton.id) {
            R.id.cbAll -> {
                if (allCheckBtn.isChecked) {
                    firstCheckBtn.isChecked = true
                    secondCheckBtn.isChecked = true
                    thirdCheckBtn.isChecked = true

                    btnGoSignIn.isEnabled = true

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
                                && thirdCheckBtn.isChecked )}
        }

        btnGoSignIn.isEnabled = allCheckBtn.isChecked
    }

//    private fun isTrue(): Boolean {
//        return name.isNotEmpty()&&email.isNotEmpty()&&pw.isNotEmpty()&&pw2.isNotEmpty()
//    }
}