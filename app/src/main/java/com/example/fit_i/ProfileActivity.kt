package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivityProfileBinding

class ProfileActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val matchRequest =findViewById<Button>(R.id.match_request_btn)
        matchRequest.setOnClickListener{
            val intent = Intent(this,ServiceActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}