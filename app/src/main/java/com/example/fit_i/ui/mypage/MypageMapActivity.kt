package com.example.fit_i.ui.mypage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMypageMapBinding

//카카오맵
class MypageMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMypageMapBinding


    override fun onCreate(savedInstanceState: Bundle?) {//
        binding = ActivityMypageMapBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_map)

    }
}