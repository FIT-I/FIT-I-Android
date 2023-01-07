package com.example.fit_i

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton

class MypageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
/*
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)
        val button: Button = view.findViewById(R.id.ib_pre1)

        val kakao_login_button = findViewById<ImageButton>(R.id.kakao_login_button) // 로그인 버튼

        kakao_login_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)  // 인텐트를 생성해줌,
            startActivity(intent)  // 화면 전환을 시켜줌
        }*/
        return view
    }
}