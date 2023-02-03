package com.example.fit_i.ui.main.matching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMatchingListBinding
import com.example.fit_i.ui.profile.ProfileActivity

class MatchingListActivity : AppCompatActivity() {
    //나중에 정의해도 됨 lateinit
    private lateinit var binding: ActivityMatchingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matching_list)
        binding = ActivityMatchingListBinding.inflate(layoutInflater)

        val btnmatching = findViewById<Button>(R.id.btn_matching_List)
        val btnback = findViewById<ImageButton>(R.id.btn_back)


        //뒤로 가기 버튼
        btnback.setOnClickListener {
            val matchingFragment = MatchingFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container,matchingFragment).commit()
        }

        // 트레이너 프로필로 이동하는 기능
        btnmatching.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }


    }
}