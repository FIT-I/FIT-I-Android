package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivityProfileBinding

class ProfileActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val matchRequest =findViewById<Button>(R.id.match_request_btn)
        fun moveToNextPage(){
            val intent = Intent(this,ServiceActivity::class.java)
            startActivity(intent)
        }
        matchRequest.setOnClickListener{
            moveToNextPage()
        }

        fun showAboutMe(){
            val intent = Intent(this,AboutMeActivity::class.java)
            startActivity(intent)
        }
        val moreAboutMe = findViewById<ImageButton>(R.id.btn_about_me)
        moreAboutMe.setOnClickListener{
            showAboutMe()
        }

        fun showAboutService(){
            val intent = Intent(this,AboutServiceActivity::class.java)
            startActivity(intent)
        }
        val moreAboutService = findViewById<ImageButton>(R.id.btn_about_service)
        moreAboutMe.setOnClickListener{
            showAboutService()
        }
    }
}