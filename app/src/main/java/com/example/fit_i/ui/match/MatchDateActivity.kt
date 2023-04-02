package com.example.fit_i.ui.match

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMatchDateBinding



class MatchDateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchDateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getLongExtra("matchIdx",-1)

        val datePickerStart = findViewById<DatePicker>(R.id.dpSpinner_start)
        val datePickerEnd = findViewById<DatePicker>(R.id.dpSpinner_end)

        binding.btnNext.setOnClickListener(){
            val start = "%04d-%02d-%02d".format(datePickerStart.year,
                    (datePickerStart.month + 1),datePickerStart.dayOfMonth)

            val end = "%04d-%02d-%02d".format(datePickerEnd.year,
                (datePickerEnd.month + 1),datePickerEnd.dayOfMonth)
            Log.d("post",start+end)

            val intent = Intent(this, MatchPickUpActivity::class.java)
            intent.putExtra("matchIdx",id)
            intent.putExtra("start",start)
            intent.putExtra("end",end)
            //세개 한번에?

            startActivity(intent)
            finish()
        }
    }
}