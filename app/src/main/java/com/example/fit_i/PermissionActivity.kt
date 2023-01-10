package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.TextView
import com.example.fit_i.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPermissionBinding


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

/*
        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                when(buttonView.id) {
                    R.id.cbAll -> { checkedToast(cb1) }
                    R.id.cb1 -> { checkedToast(cb1) }
                    R.id.cb2 -> { checkedToast(cb2) }
                    R.id.cb3 -> { checkedToast(cb3) }
                }
            }
            else {
                .
                .
                .
            }
        }

        binding.cbAll.setOnCheckedChangeListener(listener)
        binding.cb1.setOnCheckedChangeListener(listener)
        binding.cb2.setOnCheckedChangeListener(listener)
        binding.cb3.setOnCheckedChangeListener(listener)
*/
        //binding.cbAll.setOnClickListener{ onCheckChanged(binding.cbAll)}

        val allCheckBtn = binding.cbAll
        val firstCheckBtn = binding.cb1
        val secondCheckBtn = binding.cb2
        val thirdCheckBtn = binding.cb3

        allCheckBtn.setOnClickListener { onCheckChanged(allCheckBtn) }
        firstCheckBtn.setOnClickListener { onCheckChanged(firstCheckBtn) }
        secondCheckBtn.setOnClickListener { onCheckChanged(secondCheckBtn) }
        thirdCheckBtn.setOnClickListener { onCheckChanged(thirdCheckBtn) }

    }

    private fun onCheckChanged(compoundButton: CompoundButton) {
        when(compoundButton.id) {
            R.id.cbAll -> {
                if (binding.cbAll.isChecked) {
                    binding.cb1.isChecked = true
                    binding.cb2.isChecked = true
                    binding.cb3.isChecked = true
                }else {
                    binding.cbAll.isChecked = false
                    binding.cb1.isChecked = false
                    binding.cb2.isChecked = false
                    binding.cb3.isChecked = false
                }
            }
            else -> {
                binding.cbAll.isChecked = (
                        binding.cb1.isChecked
                                && binding.cb2.isChecked
                                && binding.cb3.isChecked)
            }
        }
    }
}