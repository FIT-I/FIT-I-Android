package com.example.fit_i

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.databinding.ActivityCheckMatching1Binding

class CheckMatchingActivity :AppCompatActivity(){
    private lateinit var binding:ActivityCheckMatching1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckMatching1Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_check_matching1)

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener{
            val dialog = MatchRequestDialog(this)
            dialog.matchDialog()

        }
    //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this,PickUpActivity::class.java)
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