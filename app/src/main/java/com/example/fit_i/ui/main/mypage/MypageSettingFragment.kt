package com.example.fit_i.ui.main.mypage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentTransaction
import com.example.fit_i.ProfileDialog
import com.example.fit_i.R

class MypageSettingFragment :Fragment() {
    private lateinit var binding: MypageSettingFragment


    @SuppressLint("MissingInflatedId")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val ee = inflater.inflate(R.layout.fragment_mypage_setting, container, false)

        val ibpre = ee.findViewById<View>(R.id.ib_pre1)
        val btnlogout = ee.findViewById<View>(R.id.btn_logout) as AppCompatButton
        val btnwithdraw = ee.findViewById<View>(R.id.btn_withdraw) as AppCompatButton

        ibpre.setOnClickListener{
            val mypageFragment = MypageFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            //이전 화면으로 이동
            transaction.replace(R.id.fl_container,mypageFragment)
            transaction.commit()

        }

        btnlogout.setOnClickListener {
            showProfileDialog()
        }
        btnwithdraw.setOnClickListener {
            val mypageSiginoutFragment = MypageSiginoutFragment()
            val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(R.id.fl_container,mypageSiginoutFragment)
            transaction.commit()

        }

        return ee



}

    private fun showProfileDialog() {
        ProfileDialog(requireContext()){

        }.show()
    }

}
