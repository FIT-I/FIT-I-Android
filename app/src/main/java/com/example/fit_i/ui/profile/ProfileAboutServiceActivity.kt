package com.example.fit_i.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityProfileAboutServiceBinding

class ProfileAboutServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileAboutServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileAboutServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAboutServiceContext.text=intent.getStringExtra("service")

        /*val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }*/
    }
}