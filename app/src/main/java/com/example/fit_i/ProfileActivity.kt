package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val matchRequest =findViewById<Button>(R.id.btn_match_request)
        fun moveToNextPage(){
            val intent = Intent(this,MatchServiceActivity::class.java)
            startActivity(intent)
        }
        matchRequest.setOnClickListener{
            moveToNextPage()
        }

        val moreAboutMe = findViewById<ImageButton>(R.id.btn_about_me)
        fun showAboutMe(){
            val intent = Intent(this,ProfileAboutMeActivity::class.java)
            startActivity(intent)
        }
        moreAboutMe.setOnClickListener{
            showAboutMe()
        }

        val moreAboutService = findViewById<ImageButton>(R.id.btn_about_service)
        fun showAboutService(){
            val intent = Intent(this,ProfileAboutServiceActivity::class.java)
            startActivity(intent)
        }
        moreAboutService.setOnClickListener{
            showAboutService()
        }
    }
}