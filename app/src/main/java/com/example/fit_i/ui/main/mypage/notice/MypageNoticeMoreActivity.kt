package com.example.fit_i.ui.main.mypage.notice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMypageNoticeMoreBinding
import com.example.fit_i.databinding.FragmentMypageNoticeBinding


class MypageNoticeMoreActivity : AppCompatActivity() {
    private var _binding: ActivityMypageNoticeMoreBinding? = null
    private val binding: ActivityMypageNoticeMoreBinding
        get() = requireNotNull(_binding) { "ActivityMypageNoticeMoreBinding" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_notice_more)
        _binding = ActivityMypageNoticeMoreBinding.inflate(layoutInflater)

//        val data = intent.getParcelableExtra<NoticeData>("title")
//
//        val title = intent.getStringExtra("title")
//        val contents = intent.getStringExtra("contents")
//
//        binding.tvNoticeTitle.text = title
//        binding.tvNoticeContent.text =contents



        val data = intent.getParcelableExtra<NoticeData>("notice")

        binding.tvNoticeTitle.text = data!!.title
        binding.tvNoticeContent.text = data.contents
    }
}