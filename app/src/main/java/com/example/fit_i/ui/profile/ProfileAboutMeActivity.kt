package com.example.fit_i.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityProfileAboutMeBinding

class ProfileAboutMeActivity:AppCompatActivity() {
    private lateinit var binding: ActivityProfileAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAboutMeContext.text=intent.getStringExtra("me")
        binding.tvCharNum.text= binding.tvAboutMeContext.length().toString()

        /*val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }*/
    }

}