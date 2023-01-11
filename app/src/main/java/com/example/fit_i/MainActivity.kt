package com.example.fit_i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)


        val bottomNavBar = findViewById(R.id.bottom_navi) as BottomNavigationView
        bottomNavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_fragment1 -> {
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
        //selectedItemId=R.id.item_fragment1

        val communityFragment = CommunityFragment()
        val fm:FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.fl_container,communityFragment).commit()




}



}