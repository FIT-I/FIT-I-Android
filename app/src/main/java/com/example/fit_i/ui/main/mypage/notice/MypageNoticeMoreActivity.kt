package com.example.fit_i.ui.main.mypage.notice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMypageNoticeMoreBinding
import com.example.fit_i.databinding.FragmentMypageNoticeBinding


class MypageNoticeMoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMypageNoticeMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageNoticeMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<NoticeData>("notice")

        binding.tvNoticeTitle.text = data!!.title
        binding.tvNoticeContent.text = data.contents
        Log.d("post", data.toString())
    }
}