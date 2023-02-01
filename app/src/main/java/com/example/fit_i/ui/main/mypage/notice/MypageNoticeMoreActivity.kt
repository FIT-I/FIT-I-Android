package com.example.fit_i.ui.main.mypage.notice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMypageNoticeMoreBinding


class MypageNoticeMoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMypageNoticeMoreBinding


    private fun loadData() {

        val title = intent.getStringExtra("title").toString()
        val contents = intent.getStringExtra("contents").toString()
        val createdAt = intent.getStringExtra("createdAt").toString()

        fun onBind() {
            binding.tvNoticeTitle.text = title
            binding.tvNoticeContent.text = contents
            //날짜는 없네
        }
        onBind()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_notice_more)
        binding = ActivityMypageNoticeMoreBinding.inflate(layoutInflater)

        loadData()
    }
}