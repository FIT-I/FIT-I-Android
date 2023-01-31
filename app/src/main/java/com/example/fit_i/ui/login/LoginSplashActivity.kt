package com.example.fit_i.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.fit_i.ui.main.MainActivity
import com.example.fit_i.databinding.ActivityLoginSplashBinding

class LoginSplashActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityLoginSplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // Handler의 postDelayed를 이용하면 일정 시간 후에 안에 있는 함수를 실행할 수 있습니다.
        // Handler를 만들 때에는 () 안에 Looper.getMainLooper()를 넣어주어야 에러가 나지 않습니다!
        Handler(Looper.getMainLooper()).postDelayed({
            // 현재 Activity에서 MainActivity로 이동하기 위한 Intent 변수 만들기
            val moveActivityIntent = Intent(this, MainActivity::class.java)

            // Intent에 정의된대로 MainActivity를 열기
            startActivity(moveActivityIntent)

            // 현재 Activity (SplashActivity)를 닫기
            finish();
        }, 2000) // 2000은 지연시간 설정 (2000 -> 2초, 즉 밀리초 단위로 입력해야 합니다.)
    }
}