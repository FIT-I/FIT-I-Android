package com.example.fit_i

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.fit_i.databinding.ActivityFirstBinding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.user.UserApiClient

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        binding = ActivityFirstBinding.inflate(layoutInflater)

        val initButton = findViewById<ImageButton>(R.id.ib_select) // 로그인 버튼

        initButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)  // 인텐트를 생성해줌,
            // or val intent = Intent(this@MainActivity, SubActivity::class.java)
            //자기자신 클래스의 정보와 띄워줄 화면의 정보를 적어준다.
            //intent.putExtra("msg", text_main.text.toString())
            // (key, value) 전달할 정보가 없다면 이 문장을 사용하지 않아도 됨.
            // 전달할 정보가 많다면 더 적어줄 수도 있다.
            startActivity(intent)  // 화면 전환을 시켜줌
            finish()  // main 창을 닫아줌. 닫아주지 않고싶다면 이 문장을 사용하지 않아도 됨.
        }

//        binding.ibSelect.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)  // 인텐트를 생성해줌,
//            // or val intent = Intent(this@MainActivity, SubActivity::class.java)
//            //자기자신 클래스의 정보와 띄워줄 화면의 정보를 적어준다.
//            //intent.putExtra("msg", text_main.text.toString())
//            // (key, value) 전달할 정보가 없다면 이 문장을 사용하지 않아도 됨.
//            // 전달할 정보가 많다면 더 적어줄 수도 있다.
//            startActivity(intent)  // 화면 전환을 시켜줌
//            finish()  // main 창을 닫아줌. 닫아주지 않고싶다면 이 문장을 사용하지 않아도 됨.
//        }

//        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
//            if (error != null) {
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else if (tokenInfo != null) {
//                val intent = Intent(this@FirstActivity, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
    }
}
