package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivityProfileBinding

class ProfileActivity :AppCompatActivity(){
    val binding by lazy {ActivityProfileBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        binding.reviewBtn.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }


    }
}