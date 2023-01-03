package com.example.fit_i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fit_i.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val bnv_main = findViewById<BottomNavigationView>(R.id.bottom_navi)

        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경하게 한다.
        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item_fragment1 -> {
                        // 다른 프래그먼트 화면으로 이동하는 기능
                        val homeFragment = HomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, homeFragment).commit()
                    }
                    R.id.item_fragment2 -> {
                        val communityFragment = CommunityFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, communityFragment).commit()
                    }
                    R.id.item_fragment3 -> {
                        val chatFragment = ChatFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, chatFragment).commit()
                    }

                    R.id.item_fragment4 -> {
                        val mypageFragment = MypageFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_container, mypageFragment).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.item_fragment1
        }
    }
}