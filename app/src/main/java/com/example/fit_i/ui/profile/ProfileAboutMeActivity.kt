package com.example.fit_i.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R

class ProfileAboutMeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_about_me)
        val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}