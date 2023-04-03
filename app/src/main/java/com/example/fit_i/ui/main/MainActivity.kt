package com.example.fit_i.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.fit_i.R
import com.example.fit_i.databinding.ActivityMainBinding
import com.example.fit_i.ui.main.chat.ChatFragment
import com.example.fit_i.ui.main.home.HomeFragment
import com.example.fit_i.ui.main.matching.MatchingFragment
import com.example.fit_i.ui.main.mypage.MypageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottom_navi)
        bottomNavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_fragment1 -> {
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, homeFragment).commit()
                }
//                R.id.item_fragment2 -> {
//                    val matchingFragment = MatchingFragment()
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fl_container, matchingFragment).commit()
//                }

                R.id.item_fragment2 -> {
                    val chatFragment = ChatFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, chatFragment).commit()
                }

                R.id.item_fragment3 -> {
                    val mypageFragment = MypageFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, mypageFragment).commit()
                }
            }
            true
        }

        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fl_container, homeFragment).commit()

        bottomNavBar.itemIconTintList = null
    }
    private var backPressedTime : Long = 0

    override fun onBackPressed() {
        Log.d("TAG", "뒤로가기")

        // 2초내 다시 클릭하면 앱 종료
        if (System.currentTimeMillis() - backPressedTime < 2000) {
            finish()
            return
        }

        // 처음 클릭 메시지
        Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show()
        backPressedTime = System.currentTimeMillis()
    }

}