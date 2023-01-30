package com.example.fit_i.ui.match

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMatchCheck1Binding

class MatchCheckActivity2 :AppCompatActivity(){
    private lateinit var binding:ActivityMatchCheck1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMatchCheck1Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_match_check2)

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener{
            val dialog = MatchRequestDialog(this)
            dialog.matchDialog()

        }
    //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.ib_back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this, MatchPickUpActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
//    private fun showDialog(){
//        val builder : AlertDialog.Builder = AlertDialog.Builder(this)
//
//
//
//        val inflater : LayoutInflater = layoutInflater
//        builder.setView(inflater.inflate(R.layout.dialog_match_request, null))
//
//        val alertDialog: AlertDialog = builder.create()
//        alertDialog.show()
//    }

}