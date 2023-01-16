package com.example.fit_i

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
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
    //뒤로가기
        val goBack = findViewById<ImageButton>(R.id.back_arrow)
        goBack.setOnClickListener{
            val intent = Intent(this,PickUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnNext.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder
                .setTitle("매칭요청")
                .setMessage("매칭을 요청하시겠습니까?")
//                .setPositiveButton("요청",
//                    DialogInterface.OnClickListener { dialog:DialogInterface, id ->
                        // 요청 버튼 선택 시 수행
//                    })
//                .setNegativeButton("취소",
//                    DialogInterface.OnClickListener { dialog, id ->
                        // 취소 버튼 선택 시 수행
//                    })
// Create the AlertDialog object and return it
            builder.create()
            builder.show()
        }

    }
}